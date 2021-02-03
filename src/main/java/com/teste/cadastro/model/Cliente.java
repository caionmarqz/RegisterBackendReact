package com.teste.cadastro.model;

import java.sql.Date;
import java.util.HashMap;
import java.util.InputMismatchException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.teste.cadastro.repository.ClienteRepository;

@Entity
@Table(name="clientes")
public class Cliente{
	
	private long id;

	private String nome;
	private String email;
	private String cpf;
	private Date   dta_nasc;
	
	public Cliente() {

	};
	
	public Cliente(long id, String nome, String email, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}
	
	public Date getDta_nasc() {
		return dta_nasc;
	}

	public void setDta_nasc(Date dta_nasc) {
		this.dta_nasc = dta_nasc;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
