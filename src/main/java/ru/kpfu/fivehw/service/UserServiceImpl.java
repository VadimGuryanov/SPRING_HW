package ru.kpfu.fivehw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.fivehw.dto.UserDto;
import ru.kpfu.fivehw.models.User;
import ru.kpfu.fivehw.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public void addUser(UserDto user) {
        User u = new User();
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setBirthday(user.getBirthday());
        u.setCountry(user.getCountry());
        u.setGender(user.getGender());
        repository.save(u);
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public User getUser(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteUser(long id) {
        repository.deleteById(id);
    }

}
