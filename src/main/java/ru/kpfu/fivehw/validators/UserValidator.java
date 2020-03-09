package ru.kpfu.fivehw.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.kpfu.fivehw.dto.UserDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDto user = (UserDto) o;
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty", "Empty field");
        ValidationUtils.rejectIfEmpty(errors, "password", "password.empty", "Empty field");
        ValidationUtils.rejectIfEmpty(errors, "passwordRepeat", "passwordRepeat.empty", "Empty field");
        ValidationUtils.rejectIfEmpty(errors, "birthday", "Birthday.empty", "Empty field");
        ValidationUtils.rejectIfEmpty(errors, "country", "Country.empty", "Empty field");
        ValidationUtils.rejectIfEmpty(errors, "gender", "Gender.empty", "Empty field");
        Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
        Matcher m = p.matcher(user.getEmail());
        if (!m.find()) {
            errors.reject("email", "Email is not correct");
        }
        if (!user.getPassword().equals(user.getPasswordRepeat())) {
            errors.reject("password", "Passwords isn't equals");
        }
        if (!user.getAgreement()) {
            errors.rejectValue("agreement", "Agreement.received", "Not received agreement");
        }
    }
}
