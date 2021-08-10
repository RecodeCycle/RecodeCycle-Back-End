package br.com.recodecycle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recodecycle.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByEmail(String email);
	
}
