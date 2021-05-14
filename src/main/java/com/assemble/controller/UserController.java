package com.assemble.controller;

import com.assemble.entity.UserDO;
import com.assemble.entity.UserDTO;
import com.assemble.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<UserDTO> list(){
        return  userService.list();
    }


    @PostMapping("")
    public boolean save( @RequestBody UserDO userDO){
        return  userService.save(userDO);
    }



}
