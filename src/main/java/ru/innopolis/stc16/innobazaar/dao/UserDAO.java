package ru.innopolis.stc16.innobazaar.dao;

import java.util.List;
import ru.innopolis.stc16.innobazaar.entity.User;

public interface UserDAO {

    public List<User> getAllUser();

    public void saveUser(User user);

    public User getUser(Long id);

    public User getUserByUsername(String username);

    public void deleteUser(Long id);

    public void updateUser(User user);

    public void updateUserAddress(User user);

}
