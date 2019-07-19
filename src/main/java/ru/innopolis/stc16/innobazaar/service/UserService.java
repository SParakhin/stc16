package ru.innopolis.stc16.innobazaar.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.innopolis.stc16.innobazaar.entity.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    public List<User> getAllUser();

    public void saveUser(User user);

    public User getUser(Long id);

    public User getUserByUsername(String username);

    public void deleteUser(Long id);

    public void updateUser(User user);


}
