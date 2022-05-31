package com.devmountain.watchlist.services;

import com.devmountain.watchlist.dtos.UserDto;
import com.devmountain.watchlist.entities.User;
import com.devmountain.watchlist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepositories;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public List<String> addUser(UserDto userDto){
        List<String> response = new ArrayList<>();
        User user = new User(userDto);
        userRepositories.saveAndFlush(user);
        response.add("User added successfully");
        return response;
    }
    @Override
    public List<String> userLogin(UserDto userDto){
        List<String> response = new ArrayList<>();
        Optional<User> userOptional = userRepositories.findByUsername(userDto.getUsername());
        if (userOptional.isPresent()){
            if(passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())){
                response.add("User login successful");
                response.add(String.valueOf(userOptional.get().getId()));
            } else {
                response.add("Username or password incorrect");
            }
        } else {
            response.add("Username or password incorrect");
        }
        return response;
    }
}
