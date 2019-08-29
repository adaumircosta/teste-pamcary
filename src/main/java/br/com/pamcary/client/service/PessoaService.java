package br.com.pamcary.client.service;

import java.util.List;
import java.util.Optional;

import br.com.pamcary.client.domain.Pessoa;

public interface PessoaService {
	
	public Pessoa add(Pessoa pessoa);
	
	public Pessoa edit(Pessoa pessoa);
	
	public List<Pessoa> findAll();
	
	public List<Pessoa> findyByCpf(String cpf);
	
	public List<Pessoa> findByName(String name);
	
	public void delete(String cpf);

}
