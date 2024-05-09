// package co.newtonschool.socialmedia.controller;

// import co.newtonschool.socialmedia.request.UserRegistrationRequest;
// import co.newtonschool.socialmedia.service.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.context.ApplicationContext;

// @Controller
// public class UserController {
//     @Autowired
//     private UserService userService;
//     private ApplicationContext context;

//     @PostMapping("/users")
//     public String addUser(@ModelAttribute("user") UserRegistrationRequest registrationRequest) {
//         userService.registerUser(registrationRequest);
//         return "redirect:/"; // Redirect to the homepage or any other page after successful registration
//     }
    
    

//     public void logBeans() {
//         String[] beanNames = context.getBeanDefinitionNames();
//         for (String beanName : beanNames) {
//             System.out.println(beanName);
//         }
//     }
// }
