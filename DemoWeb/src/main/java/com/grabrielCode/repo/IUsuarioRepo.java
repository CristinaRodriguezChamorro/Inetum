package com.grabrielCode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grabrielCode.model.Usuario;


public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{
	Usuario findByNombre(String pNombre);
}
