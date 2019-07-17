package ru.innopolis.stc16.innobazaar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.innopolis.stc16.innobazaar.dao.UserDAO;
import ru.innopolis.stc16.innobazaar.entity.Authorities;
import ru.innopolis.stc16.innobazaar.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Authorities authorities = new Authorities("ROLE_ADMIN");
        authorities.setUsername(user.getUsername());
        user.setAuthorities(authorities);
        userDAO.saveUser(user);
    }

    @Override
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
}