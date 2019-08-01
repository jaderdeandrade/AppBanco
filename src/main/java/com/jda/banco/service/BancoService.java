package com.jda.banco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jda.banco.domain.Banco;
import com.jda.banco.repositories.BancoRepository;
import com.jda.banco.services.exceptions.ObjectNotFoundException;

@Service
public class BancoService {

	@Autowired
	private BancoRepository repo;

	public Banco find(Integer id) {

		Optional<Banco> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Banco.class.getName()));
	}

	public Banco insert(Banco obj) {
		obj.setId(null);

		return repo.save(obj);
	}

	public Banco update(Banco obj) {
		Optional<Banco> banco = repo.findById(obj.getId());
		find(obj.getId());
		//Operacao = 1 -  deposito
		if (obj.getOperacao() == 1) {
			obj.setSaldo(banco.get().getSaldo() + obj.getSaldo());
		} else if (obj.getOperacao() == 0) {
			obj.setSaldo(banco.get().getSaldo() - obj.getSaldo());
		}
		return repo.save(obj);
	}
}
