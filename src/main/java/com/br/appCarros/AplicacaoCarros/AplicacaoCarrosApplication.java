package com.br.appCarros.AplicacaoCarros;

import com.br.appCarros.AplicacaoCarros.application.Main;
import com.br.appCarros.AplicacaoCarros.repository.CostumerRepository;
import com.br.appCarros.AplicacaoCarros.repository.DealRepository;
import com.br.appCarros.AplicacaoCarros.repository.SalesmanRepository;
import com.br.appCarros.AplicacaoCarros.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacaoCarrosApplication {
	public static void main(String[] args) {
		SpringApplication.run(AplicacaoCarrosApplication.class, args);
	}
}
