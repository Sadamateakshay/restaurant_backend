package com.restaurant.services.auth;

import com.restaurant.dtos.SignupRequest;
import com.restaurant.dtos.UserDto;
import com.restaurant.entities.User;
import com.restaurant.enums.UserRole;
import com.restaurant.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void createAdminAccount(){
        User adminAccount=userRepository.findByUserRole(UserRole.ADMIN);
        if(adminAccount==null){
            User user=new User();
            user.setName("admin");
            user.setEmail("admin@test.com");
            user.setPassword(passwordEncoder.encode("admin"));
            user.setUserRole(UserRole.ADMIN);
            userRepository.save(user);
        }
    }

    @Override
    public UserDto createUser(SignupRequest signupRequest) {
        User user=new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setUserRole(UserRole.CUSTOMER);
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        User createdUser=userRepository.save(user);
        UserDto createdUserDto=new UserDto();
        createdUserDto.setId(createdUser.getId());
        createdUserDto.setName(createdUser.getName());
        createdUserDto.setEmail(createdUser.getEmail());
        createdUserDto.setUserRole(createdUser.getUserRole());
        createdUserDto.setPassword(passwordEncoder.encode(createdUser.getPassword()));
        return createdUserDto;
    }
}
