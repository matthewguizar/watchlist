package com.devmountain.watchlist.controllers;

import com.devmountain.watchlist.dtos.UserDto;
import com.devmountain.watchlist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class IndexController {
    @Autowired
    private UserService userService;

@PostMapping("error")
    public List<String> userLogin(@RequestBody UserDto userDto){
    return userService.userLogin(userDto);
}

}
