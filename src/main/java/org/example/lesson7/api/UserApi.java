package org.example.lesson7.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.utils.DataUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserApi {
    private static final UserApi instance = new UserApi();
    private List<User> users;

    private UserApi() {
        users = initUsersFromJson();
    }

    private List<User> initUsersFromJson() {
        Type listType = new TypeToken<ArrayList<User>>() {}.getType();

        String validJson = DataUtil.getFileAsString("USER_DATA.json");
        Gson gson = new Gson();
        return gson.fromJson(validJson, listType);
    }

    public List<User> getAllUsers(){
        return users;
    }

    public static UserApi getInstance(){
        return instance;
    }

}
