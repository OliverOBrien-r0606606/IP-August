package foodz.web.controller;


import foodz.entity.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    @RequestMapping("/")
    public String indexPage() {

        return "index";
    }

    @RequestMapping("/home")
    public String mainPage() {

        return "home";
    }

    @RequestMapping("/ADMIN/test")
    public String testPage() {
        return "test";
    }


    @GetMapping("/login")
    public ModelAndView toLogin(){
        return new ModelAndView("login","User",new User());
    }


}
