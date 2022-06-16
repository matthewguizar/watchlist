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
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public List<String> addUser(UserDto userDto){
        List<String> response = new ArrayList<>();
        User user = new User(userDto);
        if (user.getUsername().matches(String.valueOf(userDto))){
            System.out.println("username already exists");
            response.add("https://onmylist.herokuapp.com/error.html");
            return response;
        }
        userRepository.saveAndFlush(user);
        response.add("https://onmylist.herokuapp.com/login.html");
        return response;
    }
    @Override
    public List<String> userLogin(UserDto userDto){
        List<String> response = new ArrayList<>();
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());
        if(userOptional.isPresent()){
            if (passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())) {
                response.add("https://onmylist.herokuapp.com/home.html");
                response.add(String.valueOf(userOptional.get().getId()));
            } else {
                response.add("https://onmylist.herokuapp.com/error.html");
            }
        } else {
            response.add("https://onmylist.herokuapp.com/error.html");
        }
        return response;
    }

}
