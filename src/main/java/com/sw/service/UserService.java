package com.sw.service;

import com.sw.dao.UserDao;
import com.sw.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<UserModel> getAllUsers(){
        return userDao.getAllUsers();
    }

    public UserModel getUser(String id) {
        return userDao.getUser(id);
    }

    boolean addUser(UserModel userModel) {
        return userDao.addUser(userModel);
    }

    boolean updateUser(String id, String name) {
        return userDao.updateUser(id, name);
    }

    boolean deleteUser(String id) {
        return userDao.deleteUser(id);
    }
}