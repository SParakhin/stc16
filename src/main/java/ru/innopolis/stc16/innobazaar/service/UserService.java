package ru.innopolis.stc16.innobazaar.service;

import ru.innopolis.stc16.innobazaar.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();

    public void saveUser(User user);

    public User getUser(Long id);

    public User getUserByUsername(String username);

    public void deleteUser(Long id);

    public User updateUserProfile(User user);

    public User updateUserLinks(User user);

    public User getAuthenticatedUser();
}
