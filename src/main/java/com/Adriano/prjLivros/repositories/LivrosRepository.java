package com.Adriano.prjLivros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Adriano.prjLivros.entities.Livros;

public interface LivrosRepository extends JpaRepository<Livros, Long> {

}
