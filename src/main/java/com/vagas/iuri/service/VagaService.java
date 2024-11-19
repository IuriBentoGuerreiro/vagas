package com.vagas.iuri.service;

import com.vagas.iuri.dto.VagaRequest;
import com.vagas.iuri.model.Vaga;
import com.vagas.iuri.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private EmpresaService empresaService;

    public Vaga salvar(VagaRequest vagaRequest){
        var vaga = new Vaga();
        vaga.setCargo(vagaRequest.cargo());
        vaga.setLink(vagaRequest.link());
        vaga.setDataPublicacao(vagaRequest.dataPublicacao());
        vaga.setLocalizacao(vagaRequest.localizacao());
        vaga.setEmpresa(empresaService.pegarPorId(vagaRequest.empresaId()));

        return vagaRepository.save(vaga);
    }

    public Vaga pegarPorId(Integer id){
        return vagaRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Não encontrado"));
    }

    public List<Vaga> listar(){
        return vagaRepository.findAll();
    }

    public List<Vaga> filtrarPorLocalizacao(String localizacao) {
        return vagaRepository.findByLocalizacaoContainingIgnoreCase(localizacao);
    }

    public List<Vaga> filtrarPorCargo(String cargo) {
        return vagaRepository.findByCargoContainingIgnoreCase(cargo);
    }
}
