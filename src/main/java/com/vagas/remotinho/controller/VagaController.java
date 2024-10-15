package com.vagas.remotinho.controller;

import com.vagas.remotinho.dto.VagaRequest;
import com.vagas.remotinho.model.Vaga;
import com.vagas.remotinho.service.VagaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    public Vaga salvar(@RequestBody VagaRequest vagaRequest){
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
    public Vaga pegarPorId(Integer id){
        return vagaService.pegarPorId(id);
    }

    @Operation(summary = "buscar vagas por localização")
    @GetMapping("procurar/localização")
    @ResponseStatus(HttpStatus.OK)
    public List<Vaga> filtrarPorLocalizacao(@RequestParam String localizacao){
        return vagaService.filtrarPorLocalizacao(localizacao);
    }

    @Operation(summary = "buscar vagas por cargo")
    @GetMapping("procurar/cargo")
    @ResponseStatus(HttpStatus.OK)
    public List<Vaga> filtrarPorCargo(String cargo){
        return vagaService.filtrarPorCargo(cargo);
    }
}
