package br.com.recodecycle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recodecycle.model.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Long> {
    
	public List<Categoria> findAllByDescricaoContainingIgnoreCase (String descricao);    

}