package com.blog_satyam.Blogging_App.services;

import com.blog_satyam.Blogging_App.entities.Category;
import com.blog_satyam.Blogging_App.entities.Post;
import com.blog_satyam.Blogging_App.entities.User;
import com.blog_satyam.Blogging_App.exceptions.ConfigDataResourceNotFoundException;
import com.blog_satyam.Blogging_App.payloads.PostDto;
import com.blog_satyam.Blogging_App.payloads.PostResponse;
import com.blog_satyam.Blogging_App.repositories.CategoryRepo;
import com.blog_satyam.Blogging_App.repositories.PostRepo;
import com.blog_satyam.Blogging_App.repositories.UserRepo;
import com.blog_satyam.Blogging_App.services.impl.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new ConfigDataResourceNotFoundException("User ","id",userId));

        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ConfigDataResourceNotFoundException("Category ","id ",categoryId));

        Post post = this.modelMapper.map(postDto,Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setCategory(category);
        post.setUser(user);
        Post newPost = this.postRepo.save(post);
        return this.modelMapper.map(newPost,PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()->new ConfigDataResourceNotFoundException("Post ","postId",postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());
        Post updatedPost = this.postRepo.save(post);
        return this.modelMapper.map(updatedPost,PostDto.class);
    }

    @Override
    public void deletePost(Long postId) {
       Post post = this.postRepo.findById(postId).orElseThrow(()->new ConfigDataResourceNotFoundException("Post ","postId",postId));
        this.postRepo.delete(post);
    }

    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir) {
        PageRequest p = null;
        if(sortDir.equalsIgnoreCase("asc")) {
             p= PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
        }else{
            p = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
        }
        Page<Post> postPage = this.postRepo.findAll(p);
        List<Post> posts = postPage.getContent();
        List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNumber(postPage.getNumber());
        postResponse.setPageSize(postPage.getSize());
        postResponse.setTotalElements(postPage.getTotalElements());
        postResponse.setTotalPages(postPage.getTotalPages());
        postResponse.setLastPage(postPage.isLast());
        return postResponse;
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()->new ConfigDataResourceNotFoundException("Post ","post id",postId));
        PostDto postDto = this.modelMapper.map(post,PostDto.class);
        return postDto;
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ConfigDataResourceNotFoundException("Category ","category id",categoryId));
        List<Post> posts = this.postRepo.findByCategory(cat);
        List<PostDto> postDtos = posts.stream().map(post -> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ConfigDataResourceNotFoundException("User "," user id",userId));

        List<Post> posts = this.postRepo.findByUser(user);

        List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
       List<Post> posts = this.postRepo.findByTitleContaining(keyword);
        List<PostDto> postDtos =posts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }
}
