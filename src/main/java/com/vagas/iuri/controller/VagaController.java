package com.vagas.iuri.controller;

import com.vagas.iuri.dto.VagaRequest;
import com.vagas.iuri.model.Vaga;
import com.vagas.iuri.service.VagaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "vaga")
@RestController
@RequestMapping("/vaga")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @Operation(summary = "salvar vaga")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vaga salvar(@Valid @RequestBody VagaRequest vagaRequest){
        return vagaService.salvar(vagaRequest);
    }

    @Operation(summary = "listar vagas")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Vaga> listar(){
        return vagaService.listar();
    }

    @Operation(summary = "buscar vaga por id")
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vaga pegarPorId(@PathVariable Integer id){
        return vagaService.pegarPorId(id);
    }

    @Operation(summary = "buscar vagas por localização")
    @GetMapping("procurar/localizacao")
    @ResponseStatus(HttpStatus.OK)
    public List<Vaga> filtrarPorLocalizacao(@RequestParam String localizacao){
        return vagaService.filtrarPorLocalizacao(localizacao);
    }

    @Operation(summary = "buscar vagas por cargo")
    @GetMapping("procurar/cargo")
    @ResponseStatus(HttpStatus.OK)
    public List<Vaga> filtrarPorCargo(@RequestParam String cargo){
        return vagaService.filtrarPorCargo(cargo);
    }
}
