package com.first_week.demo.service.impl;

import com.first_week.demo.Entity.UserDTO;
import com.first_week.demo.common.Result;
import com.first_week.demo.mapper.UserDTOmapper;
import com.first_week.demo.service.UserDTOservice;

import com.github.yulichang.base.MPJBaseServiceImpl;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserDTOserviceImpl extends MPJBaseServiceImpl<UserDTOmapper,UserDTO> implements UserDTOservice {
    @Resource
    private UserDTOmapper userMapper;
    @Override
    public Long Register(UserDTO user) {
        return this.userMapper.insertuser(user);
    }
    public List<UserDTO> SelectallUser() {
        return this.userMapper.GetAllUser();
    }

    @Override
    public UserDTO SelectById(Long id) {
        return this.userMapper.selectById(id);
    }

    @Override
    public Result<Object> DeletedById(Long id) {
        if(this.userMapper.DeleteUserById(id))
        {
            return Result.success();
        }
        else return Result.fail();
    }

    @Override
    public Result<Object> UpdateById(UserDTO userDTO) {
        if(this.userMapper.UpdateUserById(userDTO))
            return Result.success();
        else return Result.fail();
    }
}
