package com.vkatit;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vkatit.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppContext {

    @Value("classpath:USER_DATA.json")
    Resource resource;

    @Bean
    public List<User> getUsers() {
        try (InputStream inputStream = resource.getInputStream()) {
            String json = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            Type listType = new TypeToken<ArrayList<User>>() {
            }.getType();
            return new Gson().fromJson(json, listType);
        } catch (IOException e) {
            return null;
        }
    }

}
