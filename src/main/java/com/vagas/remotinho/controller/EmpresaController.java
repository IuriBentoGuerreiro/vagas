package com.vagas.remotinho.controller;

import com.vagas.remotinho.dto.EmpresaRequest;
import com.vagas.remotinho.model.Empresa;
import com.vagas.remotinho.model.Vaga;
import com.vagas.remotinho.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "empresa")
@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @Operation(summary = "salvar empresa")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa salvar(@RequestBody EmpresaRequest empresaRequest){
        return empresaService.salvar(empresaRequest);
    }

    @Operation(summary = "listar empresas")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Empresa> listar(){
        return empresaService.listar();
    }

    @Operation(summary = "buscar empresas por id")
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Empresa pegarPorId(@PathVariable Integer id){
        return empresaService.pegarPorId(id);
    }

    @Operation(summary = "buscar vagas por empresa")
    @GetMapping("vagas/{idEmpresa}")
    @ResponseStatus(HttpStatus.OK)
    public List<Vaga> pegarVagasPorEmpresa(@PathVariable Integer idEmpresa){
        return empresaService.pegarVagasPorEmpresa(idEmpresa);
    }
}
