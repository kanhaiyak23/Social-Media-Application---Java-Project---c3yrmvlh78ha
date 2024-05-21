package co.newtonschool.socialmedia.service;

import co.newtonschool.socialmedia.model.Post;
import co.newtonschool.socialmedia.request.PostRequest;
import org.springframework.http.ResponseEntity;
// Defines methods for reading, creating, liking, and unliking posts
public interface PostService {
    ResponseEntity<?> readPosts();
    ResponseEntity<?> createPost(PostRequest postRequest);
    ResponseEntity<?> likePost(int postId);
    ResponseEntity<?> unlikePost(int postId);
    
    ResponseEntity<?> deletePost(int postId);
    ResponseEntity<?> editPost(int postId, String updatedContent);
    Post getPostById(int postId);
    ResponseEntity<?> updatePost(int postId, Post post);

}
