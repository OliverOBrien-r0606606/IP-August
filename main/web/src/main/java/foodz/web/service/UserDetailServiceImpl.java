
package foodz.web.service;

import foodz.db.UserRoleRepository;
import foodz.web.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import foodz.db.UserRepository;
import foodz.entity.User.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @PostConstruct
    public void foo(){
        System.out.println("***************************foo***********************");
    }


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        User user = userRepository.getByUsername(username);


        if(user== null){
            throw new UsernameNotFoundException("No user found with username= "+username);
        }
        System.out.println("OUT MAIL: "+user.getEmail());
        System.out.println("OUT USERNAME: "+user.getUsername());
        System.out.println("OUT NAME: "+user.getName());
        System.out.println("OUT SIRNAME: "+user.getSirName());
        System.out.println("OUT ID: "+user.getUserId());
        System.out.println("OUT ENABLED: "+user.getEnabled());
        System.out.println("USER FOUND");
        List<String> roles = roleRepository.findRoleByUserName(user.getUsername());
        System.out.println(roles);
        return new CustomUserDetails(user,roles);
    }
}
