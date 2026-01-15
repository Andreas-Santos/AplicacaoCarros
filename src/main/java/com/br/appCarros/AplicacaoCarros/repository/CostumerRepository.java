package com.br.appCarros.AplicacaoCarros.repository;

import com.br.appCarros.AplicacaoCarros.model.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Costumer, Long> {
    Costumer findByIdEquals(long costumerId);
}
