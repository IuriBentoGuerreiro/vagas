package com.vagas.iuri.service;

import com.vagas.iuri.dto.EmpresaRequest;
import com.vagas.iuri.model.Empresa;
import com.vagas.iuri.model.Vaga;
import com.vagas.iuri.repository.EmpresaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa salvar(EmpresaRequest empresaRequest){
        var empresa = new Empresa();
        BeanUtils.copyProperties(empresaRequest, empresa);
        return empresaRepository.save(empresa);
    }

    public List<Empresa> listar(){
        return empresaRepository.findAll();
    }

    public Empresa pegarPorId(Integer id){
        return empresaRepository.findById(id).orElseThrow(
                ()->new NotFoundException("Não encontrado")
        );
    }

    public List<Vaga> pegarVagasPorEmpresa(Integer idEmpresa){
        var empresa = pegarPorId(idEmpresa);
        return empresa.getVaga();
    }
}
