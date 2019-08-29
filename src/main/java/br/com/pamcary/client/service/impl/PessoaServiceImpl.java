package br.com.pamcary.client.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pamcary.client.Utilities.UtilsCpf;
import br.com.pamcary.client.domain.Pessoa;
import br.com.pamcary.client.exception.MinhaException;
import br.com.pamcary.client.repository.PessoaRespository;
import br.com.pamcary.client.service.MessagesService;
import br.com.pamcary.client.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRespository repository;

	@Autowired
	private MessagesService message;

	@Override
	public Pessoa add(Pessoa pessoa) {
		boolean exists;
		String resultadoValidacaoCpf;
		resultadoValidacaoCpf = UtilsCpf.PessoaValidator.ValidatePessoaCpf(pessoa.getCpf());
		if (resultadoValidacaoCpf.equals("ok")) {
			exists = repository.existsById(pessoa.getCpf());
			if (exists) {
				throw new MinhaException(message.get("pessoa.cpf.exists"));
			}
		} else {
			throw new MinhaException(message.get("pessoa.cpf.invalid"));
		}
		return repository.saveAndFlush(pessoa);
	}

	@Override
	public Pessoa edit(Pessoa pessoa) {
		boolean exists;
		String resultadoValidacaoCpf;
		resultadoValidacaoCpf = UtilsCpf.PessoaValidator.ValidatePessoaCpf(pessoa.getCpf());
		if (resultadoValidacaoCpf.equals("ok")) {
			exists = repository.existsById(pessoa.getCpf());
			if (exists) {
				throw new MinhaException(message.get("pessoa.cpf.exists"));
			}
		} else {
			throw new MinhaException(message.get("pessoa.cpf.invalid"));
		}
		return repository.saveAndFlush(pessoa);
	}

	@Override
	public List<Pessoa> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Pessoa> findyByCpf(String cpf) {
		List<Pessoa> pessoas = repository.findByCpfContaining(cpf);
		return pessoas;
	}

	@Override
	public List<Pessoa> findByName(String name) {
		List<Pessoa> pessoas = repository.findByNameContaining(name);
		return pessoas;
	}

	@Override
	public void delete(String cpf) {
		boolean exists;
		String resultadoValidacaoCpf;
		resultadoValidacaoCpf = UtilsCpf.PessoaValidator.ValidatePessoaCpf(cpf);
		if (resultadoValidacaoCpf.equals("ok")) {
			exists = repository.existsById(cpf);
			if (exists) {
				repository.deleteById(cpf);;
			}else {
				throw new MinhaException(message.get("pessoa.cpf.no.exists"));
			}
		} else {
			throw new MinhaException(message.get("pessoa.cpf.invalid"));
		}

	}

}
