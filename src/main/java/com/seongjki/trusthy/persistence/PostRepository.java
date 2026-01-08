package com.seongjki.trusthy.persistence;

import com.seongjki.trusthy.domain.Post;

import java.util.Optional;
import java.util.UUID;

public interface PostRepository {

    Post save(Post post);

    Optional<Post> findById(UUID id);

}
