package foodz.web.security;

import foodz.entity.User.User;

public class UserRegistration {
    private String username;
    private String name;
    private String sirname;
    private String password;
    private String confirmPassword;
    private String email;

    public UserRegistration() {
    }

    public UserRegistration(String username, String name, String sirname, String password, String confirmPassword, String email) {
        this.username = username;
        this.name = name;
        this.sirname = sirname;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSirname() {
        return sirname;
    }

    public void setSirname(String sirname) {
        this.sirname = sirname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
