package com.example.wonderland.repos;

import com.example.wonderland.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, Long> {

    Page<Post> findByName(String name, Pageable pageable);

    Page<Post> findAll(Pageable pageable);

}
