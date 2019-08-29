package br.com.pamcary.client.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa{
	
	@Id
    @NotNull(message = "{pessoa.cpf.required}")
    @NotBlank(message = "{pessoa.cpf.notblank}")
    @Length(min = 11, max = 11, message = "{pessoa.cpf.invalid}")
    private String cpf;
	
	
    @NotNull(message = "{pessoa.name.required}")
    @NotBlank(message = "{pessoa.name.notblank}")
    private String name;

}
