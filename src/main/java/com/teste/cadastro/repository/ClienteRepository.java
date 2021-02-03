package com.teste.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teste.cadastro.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query(value= "SELECT u FROM Cliente u WHERE u.cpf = :cpf" , nativeQuery = false)
	List<Cliente> findCPF(String cpf);
	
}
