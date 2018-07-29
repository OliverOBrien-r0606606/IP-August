package foodz.web.service;
import foodz.db.UserRepository;
import foodz.entity.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl{

    @Autowired
    private UserRepository userRepository;


    public void save(User user) {
        user.setPassword((user.getPassword()));
        user.setRole(user.getRole());
        userRepository.save(user);
    }

    public User getByEmail(String username) {
        return userRepository.getByEmail(username);
    }
}