package co.newtonschool.socialmedia;

import co.newtonschool.socialmedia.repository.PostRepository;
import co.newtonschool.socialmedia.service.PostService;
import co.newtonschool.socialmedia.service.PostServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialMediaApplication {
	private static PostRepository postRepository;
	private static PostService postService;

	static {
		postRepository = new PostRepository();
		postService = new PostServiceImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaApplication.class, args);
	}

	public static PostRepository getPostRepository() {
		return postRepository;
	}

	public static PostService getPostService() {
		return postService;
	}
}
