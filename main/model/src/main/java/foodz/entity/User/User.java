package foodz.entity.User;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userId;
    @Column(name = "username")
    private String username;

    @Column(columnDefinition = "VARCHAR(32)", name = "name")
    private String name;

    @Column(columnDefinition = "VARCHAR(32)", name = "sir")
    private String sirName;
    @Column(columnDefinition = "VARCHAR(32)", name = "email")
    private String email;
    @Column(columnDefinition = "VARCHAR(256)", name = "pass")
    private String password;
    @Column(name = "enabled")
    private int enabled;

    public User(User user) {
        this.setUserId(user.getUserId());
        this.setName(user.getName());
        this.setEmail(user.getEmail());
        this.setSirName(user.getSirName());
        this.setEnabled(user.getEnabled());
        this.setPassword(user.getPassword());
        this.setUsername(user.getUsername());
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSirName() {
        return sirName;
    }

    public void setSirName(String sirName) {
        this.sirName = sirName;
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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public boolean authenticate(String password){
        return this.getPassword().matches(password);
    }

    public User(String username, String name, String sirName, String email, String password, int enabled) {
        this.username = username;
        this.name = name;
        this.sirName = sirName;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }

    public User() {


    }

}
