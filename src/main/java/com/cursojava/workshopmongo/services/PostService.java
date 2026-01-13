package com.cursojava.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojava.workshopmongo.domain.Post;
import com.cursojava.workshopmongo.repository.PostRepository;
import com.cursojava.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

  @Autowired
  private PostRepository repo;

  public Post findById(String id) {
    Post post = repo.findById(id).orElse(null);
    if(post == null){
      throw new ObjectNotFoundException("Objeto não encontrado");
    } else {
      return post;
    }
  }

  public List<Post> findByTitle(String text){
    return repo.searchTitle(text);
  }
}
