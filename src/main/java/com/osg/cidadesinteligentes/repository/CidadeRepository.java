package com.osg.cidadesinteligentes.repository;

import com.osg.cidadesinteligentes.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    List<Cidade> findByEstado(String estado);
    List<Cidade> findByIndiceESGGreaterThan(Double indice);
}
