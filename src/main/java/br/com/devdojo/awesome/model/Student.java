package br.com.devdojo.awesome.model;

import javax.persistence.Entity;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Student extends AbstractEntity {
	@SuppressWarnings("deprecation")
	@NotEmpty(message = " Obrigatório o preenchimento do campo nome!")
	private String name;
	
	@Email
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
