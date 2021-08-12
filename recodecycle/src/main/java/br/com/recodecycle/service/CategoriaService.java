package br.com.recodecycle.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.recodecycle.model.Categoria;
import br.com.recodecycle.repository.CategoriaRepository;
import br.com.recodecycle.repository.PostagemRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private PostagemRepository postagemRepository;

	public List<Categoria> trendTopics(){
		
		List<Categoria> categorias = categoriaRepository.findAll();
		
		for (Categoria categoria : categorias) {
	
			categoria.setQtdCategoria(postagemRepository.countPosts(categoria.getId()));
		}
		
		Collections.sort(categorias, Collections.reverseOrder(Comparator.comparing(Categoria::getQtdCategoria)));
		return categorias;
	}
}


