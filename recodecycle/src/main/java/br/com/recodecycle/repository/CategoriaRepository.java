<<<<<<< HEAD
package br.com.recodecycle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recodecycle.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	public List <Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);
	
}
=======
package br.com.recodecycle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recodecycle.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	public List <Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);
	
}
>>>>>>> a380b24f5b48925eecb285590c94bb3367ee2395
