package br.com.recodecycle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.recodecycle.model.Postagem;

@Repository
@Transactional(readOnly = true)
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	
	public List<Postagem> findByRegioesOrResiduos (String regioes, String residuos); 
	 
	@Query(value = "select count(tema_id) from postagens where tema_id = :id", nativeQuery = true)
	public int countPosts(@Param("id") long id);
	
}
