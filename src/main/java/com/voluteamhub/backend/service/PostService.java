package com.voluteamhub.backend.service;

import com.voluteamhub.backend.model.Post;
import com.voluteamhub.backend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAllByOrderByTimestampDesc();
    }

    public Post createPost(Post post) {
        // Set the timestamp and other necessary fields
        post.setTimestamp(LocalDateTime.now());
        return postRepository.save(post);
    }
}
