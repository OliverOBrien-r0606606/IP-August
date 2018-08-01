package foodz.web.controller;

import foodz.entity.User.User;
import foodz.web.security.UserRegistration;
import foodz.web.service.SecurityServiceImpl;
import foodz.web.service.UserServiceImpl;
import foodz.web.validator.UserRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @Autowired
    private SecurityServiceImpl securityService;

    @Autowired
    private UserRegistrationValidator registrationValidator;

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView registration(){
        return new ModelAndView("registration","user",new UserRegistration());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user")UserRegistration user, BindingResult error){
        registrationValidator.validate(user,error);
        if(error.hasErrors()){
            return "registration";
        }

        User newUser = new User(user.getUsername(),
                user.getName(),
                user.getSirname(),
                user.getEmail(),
                user.getPassword(),
                1);

        userService.save(newUser);
        userService.addRoleToUserByEmail(newUser.getEmail(),"ROLE_USER");
        securityService.autologin(newUser.getUsername(),user.getConfirmPassword());

        return "redirect:/";
    }

}
