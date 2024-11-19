package com.vagas.iuri.controller;


import com.vagas.iuri.security.JwtUtil;
import com.vagas.iuri.security.UserDetailsServiceImpl;
import com.vagas.iuri.enums.RoleName;
import com.vagas.iuri.model.Role;
import com.vagas.iuri.model.Usuario;
import com.vagas.iuri.repository.RoleRepository;
import com.vagas.iuri.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    private final JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public AuthController(
            AuthenticationManager authenticationManager,
            UsuarioRepository repository,
            RoleRepository roleRepository,
            JwtUtil jwtUtil,
            UserDetailsServiceImpl userDetailsService
    ) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = repository;
        this.roleRepository = roleRepository;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Usuario usuario) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(usuario.getUsername());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDetails.getUsername(), usuario.getPassword())
        );

        String token = jwtUtil.generateToken(userDetails.getUsername());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody Usuario usuario) {
        if (usuario.getUsername() == null || usuario.getPassword() == null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(usuario.getPassword());

        Role usuarioRole = roleRepository.findByRoleName(RoleName.ROLE_USUARIO)
                .orElseThrow(() -> new RuntimeException("Role USUARIO não encontrada"));

        List<Role> roles = new ArrayList<>();
        roles.add(usuarioRole);

        Usuario newUser = new Usuario(usuario.getUsername(), encryptedPassword, roles);

        usuarioRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

}
