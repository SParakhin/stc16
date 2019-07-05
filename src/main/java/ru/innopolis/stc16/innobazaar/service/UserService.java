package ru.innopolis.stc16.innobazaar.service;

import ru.innopolis.stc16.innobazaar.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);

    public void updateUser(User user);


}
