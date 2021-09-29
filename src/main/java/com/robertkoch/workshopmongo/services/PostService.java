package com.robertkoch.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertkoch.workshopmongo.domain.Post;
import com.robertkoch.workshopmongo.repository.PostRepository;
import com.robertkoch.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		/*if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}*/
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
