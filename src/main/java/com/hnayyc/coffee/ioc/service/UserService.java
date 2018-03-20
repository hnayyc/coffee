package com.hnayyc.coffee.ioc.service;

import com.hnayyc.coffee.ioc.dao.UserDao;
import com.hnayyc.coffee.ioc.model.User;

public class UserService {
    public void saveUser() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setName("cai");
        user.setPassword("123456");
        try {
            System.out.println(userDao.save(user));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
