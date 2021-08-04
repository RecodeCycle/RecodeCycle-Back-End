package br.com.recodecycle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recodecycle.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	
	public List<Postagem> findByRegioesOrResiduos (String regioes, String residuos); 
	 
}
