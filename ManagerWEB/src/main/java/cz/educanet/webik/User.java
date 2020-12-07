package cz.educanet.webik;

public class User {
    private String FirstName;
    private String LastName;
    private String username;
    private String email;
    private String password;
    public User(String FirstName, String LastName, String username, String email, String password) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}