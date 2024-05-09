package co.newtonschool.socialmedia.model;

public class User {
    private static int idCounter = 1;
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public User(String firstName, String lastName, String username, String password) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public String setFirstName(String firstName) {
        this.firstName = firstName;
        return firstName;
        
    }
    public String setLastName(String lastName) {
        this.lastName = lastName;
        return lastName;
    }
    public String setUsername(String username) {
        this.username = username;
        return username;
    }
    public String setPassword(String password) {
        this.password = password;
        return password;
    }
    


    
}
