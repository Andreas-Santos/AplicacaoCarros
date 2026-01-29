package com.br.appCarros.AplicacaoCarros.repository;

import com.br.appCarros.AplicacaoCarros.model.Deal;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {
    boolean existsByVehicleId(Long vehicleId);
}
