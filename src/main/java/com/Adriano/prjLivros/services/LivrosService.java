package com.Adriano.prjLivros.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Adriano.prjLivros.entities.Livros;
import com.Adriano.prjLivros.repositories.LivrosRepository;
@Service
public class LivrosService {
	
	private final LivrosRepository livrosRepository;
	
	public LivrosService (LivrosRepository livrosRepository) {
		this.livrosRepository = livrosRepository;
	}
	
	//inserir livro
	public Livros saveLivros (Livros livros) {
		return livrosRepository.save(livros);
	}
	
	//listar livro por Id
	public Livros getLivrosById (Long id) {
		return livrosRepository.findById(id).orElse(null);
	}
	
	//Listar todos livro
	public List<Livros> getAllLivros() {
		return livrosRepository.findAll();
	}
	
	//deletar Livro
	public void deleteLivros (Long id) {
		livrosRepository.deleteById(id);
	}
	
	//update livros
	public Livros updateLivros(Long id, Livros novoLivros) {
        Optional<Livros> livrosOptional = livrosRepository.findById(id);
        if (livrosOptional.isPresent()) {
        	Livros livrosExistente = livrosOptional.get();
           	livrosExistente.setDescricao(novoLivros.getDescricao());
        	livrosExistente.setIsbn(novoLivros.getIsbn());          
            return livrosRepository.save(livrosExistente); 
        } else {
            return null; 
        }
    }
}
