package com.assemble.service.impl;


import com.assemble.entity.UserDO;
import com.assemble.entity.UserDTO;
import com.assemble.map.UserDao;
import com.assemble.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

//    @Autowired
//    private MessageChannel<UserDO> messageChannel;


    @Override
    public List<UserDTO> list() {
        return userDao.findByQuery().stream().map(this::convert).collect(Collectors.toList());
    }

    private UserDTO convert(UserDO userDO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userDO.getId());
        userDTO.setName(userDO.getName());
        return userDTO;
    }

    @Override
    public boolean save(UserDO userDO) {

        if (userDO.getId() == 0) {
            return userDao.insert(userDO);
        }
        return userDao.update(userDO) > 0;
    }
}
