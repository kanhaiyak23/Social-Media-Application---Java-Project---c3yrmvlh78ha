// package co.newtonschool.socialmedia.service;

// import co.newtonschool.socialmedia.model.User;
// import co.newtonschool.socialmedia.repository.UserRepository;
// import co.newtonschool.socialmedia.request.UserRegistrationRequest;
// import co.newtonschool.socialmedia.response.GenericResponse;
// import org.springframework.http.ResponseEntity;

// import java.util.List;

// public class UserServiceImpl implements UserService {
//     private final UserRepository userRepository;

//     public UserServiceImpl(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     public ResponseEntity<?> registerUser(UserRegistrationRequest registrationRequest) {
//         User existingUser = userRepository.getUserByUsername(registrationRequest.getUsername());
//         if (existingUser != null) {
//             return ResponseEntity.badRequest().body(new GenericResponse("Username already exists"));
//         }

//         User newUser = new User(
//                 registrationRequest.getFirstName(),
//                 registrationRequest.getLastName(),
//                 registrationRequest.getUsername(),
//                 registrationRequest.getPassword()
//         );

//         userRepository.saveUser(newUser);
//         return ResponseEntity.ok(new GenericResponse("User registered successfully"));
//     }

//     public ResponseEntity<?> getAllUsers() {
//         List<User> users = userRepository.getAllUsers();
//         return ResponseEntity.ok(users);
//     }

//     public ResponseEntity<?> getUserById(int id) {
//         User user = userRepository.getUserById(id);
//         if (user != null) {
//             return ResponseEntity.ok(user);
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }
// }
