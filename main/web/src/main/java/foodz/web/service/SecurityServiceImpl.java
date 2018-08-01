package foodz.web.service;

import foodz.entity.User.User;
import org.omg.IOP.ServiceContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
@ComponentScan("foodz.web.config")
public class SecurityServiceImpl{

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserDetailServiceImpl userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    public String findLoggedInUserName(){
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if(userDetails instanceof UserDetails){
            return ((UserDetails)userDetails).getUsername();
        }
        return null;
    }

    public void autologin(String email, String password){
        System.out.println(email+password);
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        System.out.println("MAKING NEW TOKEN: [ " +
                "email: "+userDetails.getUsername()+ ", " +
                "pass: "+userDetails.getPassword() +"("+password+"), " +
                "role: "+userDetails.getAuthorities()+"]");
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
        System.out.println("AUTHENTICATING TOKEN");
        manager.authenticate(usernamePasswordAuthenticationToken);
        System.out.println(usernamePasswordAuthenticationToken.isAuthenticated());
        if(usernamePasswordAuthenticationToken.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("Auto login % success!",email));
        }
    }

}
