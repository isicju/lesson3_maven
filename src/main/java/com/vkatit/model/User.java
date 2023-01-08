package com.vkatit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User {
    Integer id;
    String firstname;
    String lastname;
    String email;
    String city;
}
