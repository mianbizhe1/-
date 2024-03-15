package com.first_week.demo.controller;

import com.first_week.demo.Entity.UserDTO;
import com.first_week.demo.common.Result;
import com.first_week.demo.pojo.User;
import com.first_week.demo.service.UserDTOservice;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@Tag(name = "userController",description = "用户管理")
@RestController
@RequestMapping(value = "/users")
public class UserDTOController {

    @Autowired
    private UserDTOservice userDTOservice;
    static Map<Long, User> users= Collections.synchronizedMap(new HashMap<Long,User>());

    //查询所有用户
    @GetMapping("/")
    @Operation(summary = "获取用户列表")

    public Result<String> getUserList(){
        List<UserDTO> userDTOS = userDTOservice.SelectallUser();
        String result = StringUtils.join(userDTOS,'|');
        return Result.success(result);
    }

    //增加用户
    @PostMapping("/add")
    @Operation(summary = "增加用户",description = "根据User对象创建用户")
    public Result<UserDTO> postUser(@RequestBody UserDTO userDTO){

        Long Id = userDTOservice.Register(userDTO);
        return Result.success("InsertId:"+Id);
    }


    //通过id查询用户
    @GetMapping("/{id}")
    @Operation(summary = "通过id查询用户",description = "根据url的id来获取用户详细信息")
    public UserDTO getUserById(@PathVariable Long id){
        return this.userDTOservice.SelectById(id);

    }

    //通过id更新用户
    @PutMapping("/{id}")
    @Parameter(name = "id",description = "用户编号",example = "1")
    @Operation(summary = "更新用户详细信息",description = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")

    public String putUserById(@PathVariable Long id,@RequestBody UserDTO userDTO){
        this.userDTOservice.UpdateById(userDTO);
        return "success";
    }


    //通过id删除用户
    @DeleteMapping("/{id}")
    @Operation(summary = "根据id删除用户",description = "根据url的id来指定删除对象")
    public String deleteUser(@PathVariable Long id) {
        userDTOservice.DeletedById(id);
        return "success";
    }
}






