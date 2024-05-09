package co.newtonschool.socialmedia.response;

import java.util.List;

public class PostResponseList {
    private List<PostResponse> postResponseList;
    //constructor
    public PostResponseList(List<PostResponse> postResponseList) {
        this.postResponseList = postResponseList;
    }
    //getter method
    public List<PostResponse> getPostResponseList() {
        return postResponseList;
    }
    //setter method
    public void setPostResponseList(List<PostResponse> postResponseList) {
        this.postResponseList = postResponseList;
    }
    

}
