package co.newtonschool.socialmedia.request;

public class PostRequest {
    private String content;

    public PostRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
