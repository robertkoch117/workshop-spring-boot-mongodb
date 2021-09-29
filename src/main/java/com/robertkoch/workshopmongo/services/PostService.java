package com.robertkoch.workshopmongo.services;

import java.util.Date;
import java.util.List;
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
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 21 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
