package foodz.web.validator;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import foodz.db.UserRepository;
import foodz.entity.User.User;
import foodz.web.service.UserServiceImpl;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class UserLoginValidator implements Validator {

    @Autowired
    private UserServiceImpl service;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Email", "login.error.empty.Email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Password", "login.error.empty.password");

        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        if(!user.getEmail().trim().isEmpty()){
            if(!pattern.matcher(user.getEmail()).matches()){
                errors.rejectValue("Email","login.error.invalid.email");
            }
            if(!user.getPassword().trim().isEmpty()){
                if(service.getByEmail(user.getEmail())==null){
                    errors.rejectValue("Email","login.error.invalid.combination");
                }
            }
        }


    }
}
