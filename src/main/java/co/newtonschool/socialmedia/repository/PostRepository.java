package co.newtonschool.socialmedia.repository;

import co.newtonschool.socialmedia.model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {
    private final Map<Integer, Post> postMapById = new HashMap<>();

    public Post savePost(Post post) {
        postMapById.put(post.getPostId(), post);

        return post;
    }

    public Post getPostById(int postId) {
        return postMapById.get(postId);
    }

    public List<Post> getAllPosts() {
        List<Post> postList = new ArrayList<>();
        for(Map.Entry<Integer, Post> entry : postMapById.entrySet()) {
            postList.add(entry.getValue());
        }

        return postList;
    }
}
