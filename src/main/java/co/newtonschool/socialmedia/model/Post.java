package co.newtonschool.socialmedia.model;

import java.time.LocalDateTime;

public class Post {
    private static int id=1;
    private int postId;
    private String content;
    private LocalDateTime createdAt;
    private int likeCount;
    private int unlikeCount;
    //constructor
    public Post(String content) {
        this.postId = id++;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.likeCount = 0;
        this.unlikeCount = 0;
    }
    public int getPostId() {
        return postId;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public int getLikeCount() {
        return likeCount;
    }
    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
    public int getUnlikeCount() {
        return unlikeCount;
    }
    public void setUnlikeCount(int unlikeCount) {
        this.unlikeCount = unlikeCount;
    }

   
}
