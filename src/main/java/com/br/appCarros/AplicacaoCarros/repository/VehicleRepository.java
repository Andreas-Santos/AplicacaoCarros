package com.br.appCarros.AplicacaoCarros.repository;

import com.br.appCarros.AplicacaoCarros.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
