package com.restaurant.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class AuthenticationRequest {

    private String email;

    private String password;
}
