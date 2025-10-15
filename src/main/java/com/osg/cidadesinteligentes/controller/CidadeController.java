package com.osg.cidadesinteligentes.controller;

import com.osg.cidadesinteligentes.model.Cidade;
import com.osg.cidadesinteligentes.service.CidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController {
    
    @Autowired
    private CidadeService cidadeService;
    
    @GetMapping
    public ResponseEntity<List<Cidade>> listarTodas() {
        return ResponseEntity.ok(cidadeService.listarTodas());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cidade> buscarPorId(@PathVariable Long id) {
        return cidadeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Cidade> criar(@Valid @RequestBody Cidade cidade) {
        Cidade cidadeSalva = cidadeService.salvar(cidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeSalva);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cidade> atualizar(@PathVariable Long id, @Valid @RequestBody Cidade cidade) {
        return cidadeService.buscarPorId(id)
                .map(cidadeExistente -> {
                    cidade.setId(id);
                    return ResponseEntity.ok(cidadeService.salvar(cidade));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (cidadeService.buscarPorId(id).isPresent()) {
            cidadeService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Cidade>> buscarPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(cidadeService.buscarPorEstado(estado));
    }
    
    @GetMapping("/esg/{indice}")
    public ResponseEntity<List<Cidade>> buscarPorIndiceESG(@PathVariable Double indice) {
        return ResponseEntity.ok(cidadeService.buscarPorIndiceESG(indice));
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("API Cidades ESG Inteligentes está funcionando!");
    }
}
