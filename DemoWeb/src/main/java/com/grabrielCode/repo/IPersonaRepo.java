package com.grabrielCode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grabrielCode.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer> {

}
