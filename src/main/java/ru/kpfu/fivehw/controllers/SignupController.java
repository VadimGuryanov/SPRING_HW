package ru.kpfu.fivehw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.fivehw.dto.UserDto;
import ru.kpfu.fivehw.models.User;
import ru.kpfu.fivehw.service.UserService;
import ru.kpfu.fivehw.validators.UserValidator;

@Controller
public class SignupController {

    @Autowired
    private UserService userService;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsersPage(ModelMap map) {
        map.put("users", userService.getUsers());
        return "users_table";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String getSignUpPage(ModelMap map) {
        map.put("userDto", new UserDto());
        return "signUp";
    }


    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(
        @Validated @ModelAttribute("userDto") UserDto userDto,
        BindingResult result)
    {
        if (result.hasErrors()) {
            return "signUp";
        } else {
            userService.addUser(userDto);
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("SC#getUsersPage").build();
        }
    }


}
