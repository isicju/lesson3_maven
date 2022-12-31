package org.example;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.example.lesson7.api.User;
import org.example.online.UserApiService;
import org.example.utils.DataUtil;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String userString = "{\"id\":1,\"firstname\":\"Skippie\",\"lastname\":\"Buggy\",\"email\":\"sbuggy0@psu.edu\",\"ipaddress\":\"44.169.186.49\",\"city\":\"Vodyane\"}";
        Gson gson = new Gson();
        User user = gson.fromJson(userString, User.class);


        UserApiService myInstance = UserApiService.getInstance();
        myInstance.getUsers();
        File userData =  DataUtil.getFileByPath("USER_DATA.json");
        String stringContent = FileUtils.readFileToString(userData, "UTF-8");
        System.out.println("");
    }


}
