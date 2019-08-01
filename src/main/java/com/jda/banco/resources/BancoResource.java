package com.jda.banco.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jda.banco.domain.Banco;
import com.jda.banco.service.BancoService;


@RestController
@RequestMapping(value = "/bancos")
public class BancoResource {
	
	@Autowired
	private BancoService service;

	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Banco> find(@PathVariable Integer id) {
		Banco obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	

	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Banco obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Banco obj, @PathVariable Integer id) {
		double valor = 0;
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}	

}
