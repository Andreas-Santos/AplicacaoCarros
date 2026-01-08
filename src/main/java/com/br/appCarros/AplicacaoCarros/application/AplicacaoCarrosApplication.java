package com.br.appCarros.AplicacaoCarros.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacaoCarrosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoCarrosApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
        Main main = new Main();
        main.showMenu();
    }
}
