package com.osg.cidadesinteligentes.service;

import com.osg.cidadesinteligentes.model.Cidade;
import com.osg.cidadesinteligentes.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    public List<Cidade> listarTodas() {
        return cidadeRepository.findAll();
    }
    
    public Optional<Cidade> buscarPorId(Long id) {
        return cidadeRepository.findById(id);
    }
    
    public Cidade salvar(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }
    
    public void deletar(Long id) {
        cidadeRepository.deleteById(id);
    }
    
    public List<Cidade> buscarPorEstado(String estado) {
        return cidadeRepository.findByEstado(estado);
    }
    
    public List<Cidade> buscarPorIndiceESG(Double indice) {
        return cidadeRepository.findByIndiceESGGreaterThan(indice);
    }
}
