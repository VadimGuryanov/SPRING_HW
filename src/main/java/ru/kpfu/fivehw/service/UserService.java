package ru.kpfu.fivehw.service;

import ru.kpfu.fivehw.dto.UserDto;
import ru.kpfu.fivehw.models.User;

import java.util.List;

public interface UserService {

    void addUser(UserDto user);
    List<User> getUsers();
    User getUser(long id);
    void deleteUser(long id);

}
