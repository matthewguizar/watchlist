package com.devmountain.watchlist.controllers;

import com.devmountain.watchlist.dtos.UserDto;
import com.devmountain.watchlist.entities.User;
import com.devmountain.watchlist.repositories.UserRepository;
import com.devmountain.watchlist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("register")
    public List<String> addUser(@RequestBody UserDto userDto){
        Optional<User>  userOptional = userRepository.findByUsername(String.valueOf(userDto));
        if (userOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
        }
        String passHash = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(passHash);
        return userService.addUser(userDto);
    }

    @PostMapping("login")
    public List<String> userLogin(@RequestBody UserDto userDto){
        return userService.userLogin(userDto);
    }
}
