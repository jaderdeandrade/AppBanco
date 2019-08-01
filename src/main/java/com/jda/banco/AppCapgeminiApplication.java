package com.jda.banco;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jda.banco.domain.Banco;
import com.jda.banco.repositories.BancoRepository;

@SpringBootApplication
public class AppCapgeminiApplication implements CommandLineRunner {
	
	@Autowired
	private BancoRepository bancoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppCapgeminiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Banco bc01 = new Banco(null,"Jader de Andrade", 1000.0,1);

		
		bancoRepository.saveAll(Arrays.asList(bc01));
	}

}
