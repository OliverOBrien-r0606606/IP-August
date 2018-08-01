package foodz.web.validator;

import foodz.web.security.UserRegistration;
import foodz.web.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class UserRegistrationValidator implements Validator {

    @Autowired
    private UserServiceImpl service;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegistration.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserRegistration user = (UserRegistration) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "registration.error.empty.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "registration.error.empty.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "registration.error.empty.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sirname", "registration.error.empty.sirname");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "registration.error.empty.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "registration.error.empty.confirmPassword");

        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        if(!errors.hasErrors()){
            if(!pattern.matcher(user.getEmail()).matches()){
                errors.rejectValue("email","registration.error.invalid.email");
            }
            if(service.getByEmail(user.getEmail())!=null){
                errors.rejectValue("email","registration.error.inUse.email");
            }
            if(service.getByUsername(user.getUsername())!=null){
                errors.rejectValue("username","registration.error.inUse.username");
            }
            if(!user.getConfirmPassword().equals(user.getPassword())){
                errors.rejectValue("confirmPassword","registration.error.mismatchPass");
            }
        }




    }
}
