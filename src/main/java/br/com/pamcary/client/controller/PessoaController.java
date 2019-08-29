package br.com.pamcary.client.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pamcary.client.domain.Pessoa;
import br.com.pamcary.client.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Pessoa Controller", tags = {"Pessoa Api"})
@RequestMapping(value = "/ws-client/api/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping
	@ApiOperation(value = "Trazer todos as pessoas cadastradas")
	public ResponseEntity listAll(){
		List<Pessoa> pessoas = service.findAll();
		return !pessoas.isEmpty() ? ResponseEntity.ok(pessoas) : ResponseEntity.notFound().build();
	}
	
	@GetMapping(value = "/cpf/{cpf}")
	@ApiOperation(value = "Trazer todos as pessoas cadastradas com base em um trecho do cpf")
	public ResponseEntity findCpfs(@Valid @NotBlank @NotNull @PathVariable(required = true) String cpf){
		List<Pessoa> pessoas = service.findyByCpf(cpf);
		return !pessoas.isEmpty() ? ResponseEntity.ok(pessoas) : ResponseEntity.notFound().build();
	}
	
	@GetMapping(value = "/name/{name}")
	@ApiOperation(value = "Trazer todos as pessoas cadastradas com base em um trecho do nome")
	public ResponseEntity findNames(@Valid @NotBlank @NotNull @PathVariable(required = true) String name){
		List<Pessoa> pessoas = service.findByName(name);
		return !pessoas.isEmpty() ? ResponseEntity.ok(pessoas) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ApiOperation(value = "Cadastrar uma pessoa")
	public ResponseEntity<Pessoa> adicionar(@Valid @RequestBody (required = true) Pessoa pessoa){
		Pessoa body= service.add(pessoa); 
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}
	
	@PutMapping
	@ApiOperation(value = "Editar uma pessoa")
	public ResponseEntity<Pessoa> editar(@Valid @RequestBody (required = true) Pessoa pessoa){
		Pessoa body = service.edit(pessoa);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(body);
	}
	
	@DeleteMapping(value = "/{cpf}")
	@ApiOperation(value = "Deletar uma pessoa")
	public ResponseEntity<Pessoa> deletar(@PathVariable(required = true) String cpf){
		service.delete(cpf);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	

}
