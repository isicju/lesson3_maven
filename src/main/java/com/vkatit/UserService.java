package com.vkatit;

import com.vkatit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    List<User> users;

    public List<User> getUsers() {
        return users.subList(0,100);
    }

}
