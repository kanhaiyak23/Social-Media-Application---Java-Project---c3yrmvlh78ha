package co.newtonschool.socialmedia;

import co.newtonschool.socialmedia.repository.PostRepository;
import co.newtonschool.socialmedia.service.PostService;
import co.newtonschool.socialmedia.service.PostServiceImpl;
// import co.newtonschool.socialmedia.service.UserService;
// import co.newtonschool.socialmedia.service.UserServiceImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.Bean;
// import org.springframework.stereotype.Controller;
// import co.newtonschool.socialmedia.service.UserService;
// import co.newtonschool.socialmedia.service.UserServiceImpl;

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
