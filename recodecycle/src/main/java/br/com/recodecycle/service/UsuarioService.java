package br.com.recodecycle.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.recodecycle.model.Usuario;
import br.com.recodecycle.model.UsuarioLogin;
import br.com.recodecycle.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario cadastrarUsuario(Usuario usuario) {
		
		if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "usuário já existe!", null);
		
		BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
		
		String senhaEnconder = enconder.encode(usuario.getSenha());
		usuario.setSenha(senhaEnconder);
		
		return usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> atualizarUsuario(Usuario usuario) {
		
		if(usuarioRepository.findById(usuario.getId()).isPresent()) {
			
			Optional<Usuario> buscaUsuario = usuarioRepository.findByEmail(usuario.getEmail());
			
			if( buscaUsuario.isPresent() ){

				if(buscaUsuario.get().getId() != usuario.getId())
					throw new ResponseStatusException(
						HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
			}


			BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
			
			String senhaEnconder = enconder.encode(usuario.getSenha());
			usuario.setSenha(senhaEnconder);
			
			return Optional.of(usuarioRepository.save(usuario));
			
		}else {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);
		}
	}
	
	public Optional<UsuarioLogin> logarUsuario(Optional<UsuarioLogin> usuarioLogin) {
		
		BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioLogin.get().getEmail());
		
		if (usuario.isPresent() ) {
			if (enconder.matches(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {
				
				String auth = usuarioLogin.get().getEmail() + ":" + usuarioLogin.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				usuarioLogin.get().setToken(authHeader);
				usuarioLogin.get().setId(usuario.get().getId());
				usuarioLogin.get().setNome(usuario.get().getNome());
				usuarioLogin.get().setSenha(usuario.get().getSenha());
				usuarioLogin.get().setFotoPerfil(usuario.get().getFotoPerfil());
				usuarioLogin.get().setNivel(usuario.get().getNivel());
				
				return usuarioLogin;
				
			}
		}
		
		throw new ResponseStatusException(
				HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos!", null);
	}
}
