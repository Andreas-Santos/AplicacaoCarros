package com.br.appCarros.AplicacaoCarros.repository;

import com.br.appCarros.AplicacaoCarros.model.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesmanRepository extends JpaRepository<Salesman, Long> {

    List<Salesman> findByNameContainingIgnoreCase(String name);

    Salesman findByIdEquals(long salesmanId);
}
