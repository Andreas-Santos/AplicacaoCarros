package com.br.appCarros.AplicacaoCarros.repository;

import com.br.appCarros.AplicacaoCarros.model.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesmanRepository extends JpaRepository<Salesman, Long> {

    List<Salesman> findByNameContainingIgnoreCase(String name);
}
