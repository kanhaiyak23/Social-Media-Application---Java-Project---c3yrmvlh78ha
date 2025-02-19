package co.newtonschool.socialmedia.service;

import co.newtonschool.socialmedia.model.Post;
import co.newtonschool.socialmedia.repository.PostRepository;
import co.newtonschool.socialmedia.request.PostRequest;
import co.newtonschool.socialmedia.response.GenericResponse;
import co.newtonschool.socialmedia.response.PostResponse;
import co.newtonschool.socialmedia.response.PostResponseList;

// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// Implements the PostService interface and provides logic for the defined
//  methods using the PostRepository to interact with post data.

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
//     
public ResponseEntity<?> deletePost(int postId) {
    Post post = postRepository.getPostById(postId);

    if (post != null) {
        postRepository.deletePost(postId);
        return ResponseEntity.ok(new GenericResponse("Post deleted"));
    } else {
        return ResponseEntity.notFound().build();
    }
}
public ResponseEntity<?> editPost(int postId, String updatedContent) {
    Post post = postRepository.getPostById(postId);
    if (post != null) {
        post.setContent(updatedContent);
        postRepository.savePost(post);
        return ResponseEntity.ok(new GenericResponse("Post updated successfully"));
    } else {
        return ResponseEntity.notFound().build();
    }
}
@Override
    public Post getPostById(int postId) {
        return postRepository.getPostById(postId);
    }
    @Override
    public ResponseEntity<?> updatePost(int postId, Post post) {
        // Get the existing post by ID
        Post existingPost = postRepository.getPostById(postId);
        
        if (existingPost != null) {
            // Update the existing post with new content
            existingPost.setContent(post.getContent());
            
            // Save the updated post
            postRepository.savePost(existingPost);
            
            return ResponseEntity.ok(new GenericResponse("Post updated successfully"));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
