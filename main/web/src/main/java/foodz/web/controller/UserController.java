package foodz.web.controller;

import foodz.entity.User.User;
import foodz.web.service.SecurityServiceImpl;
import foodz.web.service.UserServiceImpl;
import foodz.web.validator.UserLoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private SecurityServiceImpl securityService;

    @Autowired
    private UserLoginValidator loginValidator;

    @RequestMapping("/toLogin")
    public ModelAndView toLogin(){
        return new ModelAndView("login","User",new User());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("User")User user, BindingResult result){
        loginValidator.validate(user,result);
        if(result.hasErrors()){
            return "login";
        }
        return "redirect:/home";
    }
}
