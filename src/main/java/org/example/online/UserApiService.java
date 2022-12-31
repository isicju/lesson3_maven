package org.example.online;

import org.example.lesson7.api.User;

import java.util.ArrayList;
import java.util.List;

public class UserApiService {

    private List<User> users = new ArrayList<>();

    private static final UserApiService instance = new UserApiService();

    private UserApiService() {

    }

    public static UserApiService getInstance() {
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }


}
