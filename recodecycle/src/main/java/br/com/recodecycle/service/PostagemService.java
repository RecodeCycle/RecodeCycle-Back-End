package br.com.recodecycle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.recodecycle.model.Postagem;
import br.com.recodecycle.repository.PostagemRepository;

@Service
public class PostagemService {

	@Autowired
	private PostagemRepository postagemRepository;

	public Postagem curtir(Long id) {
		
		Postagem postagem = buscarPostagemPeloId(id);
		
		postagem.setCurtidas(postagem.getCurtidas() + 1);
		
		return postagemRepository.save(postagem);
		
	}

	public Postagem descurtir(Long id) {
		
		Postagem postagem = buscarPostagemPeloId(id);
		
		if (postagem.getCurtidas() > 0) {
			
			postagem.setCurtidas(postagem.getCurtidas() - 1);
			
		}else {
			
			postagem.setCurtidas(0);
		
		}
		
		return postagemRepository.save(postagem);
	
	}

	private Postagem buscarPostagemPeloId(Long id) {
		
        Postagem postagemSalva = postagemRepository.findById(id).orElse(null);

        if (postagemSalva == null) {
             
        	throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Postagem não encontrada!", null);
        } 
        
        	return postagemSalva;
    }
	
}
