package foodz.web.service;
import foodz.db.UserRepository;
import foodz.db.UserRoleRepository;
import foodz.entity.User.User;
import foodz.entity.User.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@ComponentScan("foodz.db")
public class UserServiceImpl{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;


    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println("USER MAIL: "+user.getEmail());
        System.out.println("USER USERNAME: "+user.getUsername());
        System.out.println("USER NAME: "+user.getName());
        System.out.println("USER SIRNAME: "+user.getSirName());
        System.out.println("USER ENABLED: "+user.getEnabled());
        System.out.println("USER PASS: "+user.getPassword());
        userRepository.save(user);
    }

    public void addRoleToUserByEmail(String email,String role){
        roleRepository.save(new UserRole(userRepository.getByEmail(email).getUserId(),role));
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    public boolean validateUser (String email, String pass){
        User out = getByEmail(email);
        System.out.println("OUT MAIL: "+out.getEmail());
        System.out.println("OUT USERNAME: "+out.getUsername());
        System.out.println("OUT NAME: "+out.getName());
        System.out.println("OUT SIRNAME: "+out.getSirName());
        System.out.println("OUT ID: "+out.getUserId());
        System.out.println("OUT ENABLED: "+out.getEnabled());

        return out.authenticate(pass);
    }
}