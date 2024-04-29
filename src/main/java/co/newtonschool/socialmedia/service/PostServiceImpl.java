package co.newtonschool.socialmedia.service;

import co.newtonschool.socialmedia.model.Post;
import co.newtonschool.socialmedia.repository.PostRepository;
import co.newtonschool.socialmedia.request.PostRequest;
import co.newtonschool.socialmedia.response.GenericResponse;
import co.newtonschool.socialmedia.response.PostResponse;
import co.newtonschool.socialmedia.response.PostResponseList;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static co.newtonschool.socialmedia.SocialMediaApplication.getPostRepository;

public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl() {
        postRepository = getPostRepository();
    }

    public ResponseEntity<?> readPosts() {
        List<Post> postList = postRepository.getAllPosts();

        List<PostResponse> postResponseList = new ArrayList<>();
        for(Post post : postList) {
            PostResponse postResponse = new PostResponse(
                    post.getPostId(),
                    post.getContent(),
                    post.getCreatedAt(),
                    post.getLikeCount(),
                    post.getUnlikeCount()
            );

            postResponseList.add(postResponse);
        }

        PostResponseList posts = new PostResponseList(postResponseList);

        return ResponseEntity.ok(posts);
    }

    public ResponseEntity<?> createPost(PostRequest postRequest) {
        Post post = new Post(
                postRequest.getContent()
        );

        postRepository.savePost(post);

        return ResponseEntity.ok(new GenericResponse("Post Added Successfully"));
    }

    public ResponseEntity<?> likePost(int postId) {
        Post post = postRepository.getPostById(postId);

        int likeCount = post.getLikeCount();
        likeCount++;

        post.setLikeCount(likeCount);

        postRepository.savePost(post);

        return ResponseEntity.ok(new GenericResponse("Liked"));
    }
    public ResponseEntity<?> unlikePost(int postId) {
        Post post = postRepository.getPostById(postId);

        int unlikeCount = post.getUnlikeCount();
        unlikeCount++;

        post.setUnlikeCount(unlikeCount);

        postRepository.savePost(post);

        return ResponseEntity.ok(new GenericResponse("Unliked"));
    }
}
