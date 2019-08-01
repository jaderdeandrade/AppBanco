package com.jda.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jda.banco.domain.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer>{

}
