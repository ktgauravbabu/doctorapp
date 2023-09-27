package com.myblog8.myblog8.service.impl;

import com.myblog8.myblog8.entity.Post;
import com.myblog8.myblog8.exception.ResourceNotFound;
import com.myblog8.myblog8.payload.PostDto;
import com.myblog8.myblog8.repository.PostRepository;
import com.myblog8.myblog8.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto savePost(PostDto postDto) {
        Post post = mapToEntity(postDto);

        Post savedPost = postRepository.save(post);
        PostDto dto = mapToDto(savedPost);
        return dto;


    }

    @Override
    public void deletePost(long id) {


    }

    @Override
    public void updatePost(long id, PostDto postDto) {
        Post post = postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFound("Post not found with id"+id)
        );
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Post not found with id" + id)
        );
        PostDto dto = mapToDto(post);
        return dto;
    }
    PostDto mapToDto(Post post){
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }
   Post mapToEntity(PostDto postDto){
       Post post = new Post();
       post.setTitle(postDto.getTitle());
       post.setDescription(postDto.getDescription());
       post.setContent(postDto.getContent());
       return post;
    }
}
