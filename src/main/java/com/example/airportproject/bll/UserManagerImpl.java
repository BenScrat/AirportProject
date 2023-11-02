package com.example.airportproject.bll;

import com.example.airportproject.bo.User;
import com.example.airportproject.dal.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagerImpl  implements UserManager {

    @Autowired
    UserDAO userDAO;


    @Override
    public void addUser(User user) {
        userDAO.save(user);
    }
}
