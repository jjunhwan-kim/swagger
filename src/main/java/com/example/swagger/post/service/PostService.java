package com.example.swagger.post.service;

import com.example.swagger.post.request.PostCreateRequest;
import com.example.swagger.post.request.PostUpdateRequest;
import com.example.swagger.post.response.PostCreateResponse;
import com.example.swagger.post.response.PostListReadResponse;
import com.example.swagger.post.response.PostReadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    public PostListReadResponse getPosts(Integer page,
                                         Integer size,
                                         String sort) {
        return null;
    }

    public PostReadResponse getPost(Long id) {
        return null;
    }

    public PostCreateResponse createPost(PostCreateRequest request) {
        return null;
    }

    public void updatePost(Long id, PostUpdateRequest request) {
    }

    public void deletePost(Long id) {
    }
}
