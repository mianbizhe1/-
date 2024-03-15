package com.first_week.demo.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.first_week.demo.Entity.UserDTO;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
@TableName("user")
public interface UserDTOmapper extends MPJBaseMapper<UserDTO> {
    public List<UserDTO> GetAllUser();
    public Boolean DeleteUserById(Long id);
    public Long insertuser(UserDTO user);
    public UserDTO GetUserById(Long id);
    public Boolean UpdateUserById(UserDTO user);
    public UserDTO selectByid(Long id);

}
