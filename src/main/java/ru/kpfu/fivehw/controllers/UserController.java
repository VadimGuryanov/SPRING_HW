package ru.kpfu.fivehw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.fivehw.dto.ResponseUserDto;
import ru.kpfu.fivehw.dto.ResponseUsersDto;
import ru.kpfu.fivehw.dto.UserDto;
import ru.kpfu.fivehw.service.UserService;
import ru.kpfu.fivehw.validators.UserValidator;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseUsersDto getUsers(ModelMap map) {
        ResponseUsersDto response = new ResponseUsersDto();
        response.setData(userService.getUsers());
        return response;
    }

    @RequestMapping(value = "/user/{user-id}", method = RequestMethod.GET)
    public ResponseUserDto getUser(@PathVariable("user-id") Long userId) {
        ResponseUserDto response = new ResponseUserDto();
        response.setData(userService.getUser(userId));
        return response;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseUserDto addUser(
            @Validated @ModelAttribute("userDto") UserDto userDto,
            BindingResult result)
    {
        ResponseUserDto response = new ResponseUserDto();
        if (result.hasErrors()) {
            response.setMessage(result.getAllErrors().toString());
            return response;
        } else {
            userService.addUser(userDto);
            response.setMessage("Successfully");
            return response;
        }
    }

    @RequestMapping(value = "/user/{user-id}", method = RequestMethod.POST)
    public ResponseUserDto deleteUser(
            @PathVariable("user-id") Long userId,
            @Validated @ModelAttribute("userDto") UserDto userDto,
            BindingResult result)
    {
        ResponseUserDto response = new ResponseUserDto();
        if (result.hasErrors()) {
            response.setMessage(result.getAllErrors().toString());
            return response;
        } else {
            userService.deleteUser(userId);
            response.setMessage("Successfully");
            return response;
        }
    }

}
