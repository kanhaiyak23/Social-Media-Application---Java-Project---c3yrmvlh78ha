package co.newtonschool.socialmedia.controller;

import co.newtonschool.socialmedia.request.PostRequest;
import co.newtonschool.socialmedia.response.PostResponse;
import co.newtonschool.socialmedia.response.PostResponseList;
import co.newtonschool.socialmedia.service.PostService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static co.newtonschool.socialmedia.SocialMediaApplication.getPostService;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;

    @PostConstruct
    void init() {
        postService = getPostService();
    }

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
        return postService.likePost(postId);
    }

    @PostMapping("/{postId}/unlike")
    public ResponseEntity<?> unlikePost(@PathVariable("postId") int postId) {
        return postService.unlikePost(postId);
    }
}
