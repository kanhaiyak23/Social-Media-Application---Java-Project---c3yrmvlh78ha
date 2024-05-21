package co.newtonschool.socialmedia.controller;

import co.newtonschool.socialmedia.model.Post;
import co.newtonschool.socialmedia.request.PostRequest;
import co.newtonschool.socialmedia.response.PostResponse;
import co.newtonschool.socialmedia.response.PostResponseList;
import co.newtonschool.socialmedia.service.PostService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.List;

import static co.newtonschool.socialmedia.SocialMediaApplication.getPostService;
// Manages operations related to posts such as reading posts, adding posts, liking, and unliking posts.

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;

    @PostConstruct
    void init() {
        postService = getPostService();
    }

    @SuppressWarnings("null")
    @GetMapping("")
    public ModelAndView readPosts() {
        ModelAndView modelAndView = new ModelAndView();
        ResponseEntity<?> responseEntity = postService.readPosts();

        PostResponseList postResponseList = (PostResponseList) responseEntity.getBody();
        
        List<PostResponse> postResponses = postResponseList.getPostResponseList();

        
        modelAndView.addObject("postList", postResponses);
        modelAndView.setViewName("post-list");

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addPost() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("add-post");

        return modelAndView;
    }

    @PostMapping("")
    public ModelAndView createPosts(PostRequest postRequest) {
        postService.createPost(postRequest);

        return new ModelAndView("redirect:" + "/posts");
    }

    @PostMapping("/{postId}/like")
    public ResponseEntity<?> likePost(@PathVariable("postId") int postId) {
        System.out.println(postId);
        return postService.likePost(postId);
    }

    @PostMapping("/{postId}/unlike")
    public ResponseEntity<?> unlikePost(@PathVariable("postId") int postId) {
        return postService.unlikePost(postId);
    }
    // @PostMapping("/{postId}/edit")
    // public ModelAndView editPost(@PathVariable("postId") int postId, String updatedContent) {
    //     postService.editPost(postId, updatedContent);
    //     return new ModelAndView("redirect:/posts");
    // }
    // @PostMapping("/{postId}")
    // public ResponseEntity<?> deletePost(@PathVariable("postId") int postId) {
    //     postService.deletePost(postId);
    //     return postService.deletePost(postId);
    // }
    // // @PostMapping("/user")
    // // public ResponseEntity<?> getUserPosts() {
    // //     return postService.readPosts();
    // // }
    // private PostService postService;

    // @DeleteMapping("/posts/{postId}")
    // public ResponseEntity<?> deletePost(@PathVariable("postId") int postId) {
    //     return postService.deletePost(postId);
    // }
    public String editPostForm(@PathVariable("postId") int postId, Model model) {
        // Fetch the post from the service based on the postId
        Post post = postService.getPostById(postId);
        
        // Add the post to the model for the edit form
        model.addAttribute("post", post);
        
        return "edit-post"; // Return the name of the Thymeleaf template for editing post
    }

    // Handle POST request to update the post
    @PostMapping("posts/{postId}/edit")
    public String updatePost(@PathVariable("postId") int postId, Post updatedPost) {
        // Update the post using the postService
        postService.updatePost(postId, updatedPost);
        
        // Redirect to the post list page after editing
        return "redirect:/posts";
    }



    
    
    
}
