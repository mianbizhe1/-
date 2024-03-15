package com.first_week.demo.service;

import com.first_week.demo.Entity.UserDTO;
import com.first_week.demo.common.Result;
import com.github.yulichang.base.MPJBaseService;

import java.util.List;


public interface UserDTOservice extends MPJBaseService<UserDTO> {
    public Long Register(UserDTO user);
    public List<UserDTO> SelectallUser();
    public UserDTO SelectById(Long id);
    public Result<Object> DeletedById(Long id);
    public Result<Object> UpdateById(UserDTO userDTO);
}
