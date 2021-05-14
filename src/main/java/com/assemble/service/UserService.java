package com.assemble.service;





import com.assemble.entity.UserDO;
import com.assemble.entity.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> list();
    boolean save(UserDO userDO);
}
