package com.myblog8.myblog8.service;

import com.myblog8.myblog8.payload.PostDto;

public interface PostService {
    PostDto savePost(PostDto postDto);

    void deletePost(long id);

    void updatePost(long id, PostDto postDto);

    PostDto getPostById(long id);
}
