package ru.innopolis.stc16.innobazaar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.innopolis.stc16.innobazaar.dao.RoleDao;
import ru.innopolis.stc16.innobazaar.dao.UserDAO;
import ru.innopolis.stc16.innobazaar.entity.User;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_USER")));
        userDAO.saveUser(user);
    }

    @Override
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Override
    public User updateUser(User user) {
        User oldUser = getUserByUsername(user.getUsername());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPhone(user.getPhone());
        oldUser.setBasket(user.getBasket());
        oldUser.setAddressList(user.getAddressList());
        oldUser.setStoreList(user.getStoreList());
        oldUser.setBookings(user.getBookings());
        oldUser.setEnabled(user.isEnabled());
        return userDAO.updateUser(oldUser);
    }

    @Override
    public User getAuthenticatedUser() {
        Authentication userAuth = SecurityContextHolder.getContext().getAuthentication();
        String username = userAuth.getName();
        User user = userDAO.getUserByUsername(username);
        return user;
    }
}