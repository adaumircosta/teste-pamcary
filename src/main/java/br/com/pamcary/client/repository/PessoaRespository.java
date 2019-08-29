package br.com.pamcary.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;

import br.com.pamcary.client.domain.Pessoa;

@Repository
public interface PessoaRespository extends JpaRepository<Pessoa, String>{
	
	List<Pessoa> findByCpfContaining(String cpf);
	
	List<Pessoa> findByNameContaining(String name);
}
