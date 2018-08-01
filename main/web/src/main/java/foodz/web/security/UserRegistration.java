package foodz.web.security;

import foodz.entity.User.User;

public class UserRegistration extends User {
    private String confirmPassword;

    public UserRegistration() {
        super();
    }

    public UserRegistration(String username, String name, String sirname, String password, String confirmPassword, String email) {
        super(username, name, sirname, email, password, 1);
        this.confirmPassword = confirmPassword;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean confirmPassword(){
        return confirmPassword.equals(super.getPassword());
    }

}
