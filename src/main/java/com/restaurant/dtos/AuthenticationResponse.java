package com.restaurant.dtos;

import com.restaurant.enums.UserRole;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class AuthenticationResponse {

    private String jwt;

    private UserRole userRole;

    private Long userId;

}
