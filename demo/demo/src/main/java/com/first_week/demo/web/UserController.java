package com.first_week.demo.web;

import com.first_week.demo.pojo.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@Tag(name = "userController",description = "用户管理")
@RestController
@RequestMapping(value = "/users")
public class UserController {

    static Map<Long, User> users= Collections.synchronizedMap(new HashMap<Long,User>());

    //查询所有用户
    @GetMapping("/")
    //@ApiOperation(value="获取用户列表")
    @Operation(summary = "获取用户列表")
    public List<User> getUserList(){
        return new ArrayList<User>(users.values());
    }

    //增加用户
    @PostMapping("/")
    //@ApiOperation(value="增加用户",notes = "根据User对象创建用户")
    @Operation(summary = "增加用户",description = "根据User对象创建用户")
    public String postUser(@RequestBody User user){

        users.put(user.getId(),user);
        return "success";
    }


    //通过id查询用户
    @GetMapping("/{id}")
    //@ApiOperation(value="通过id查询用户",notes = "根据url的id来获取用户详细信息")
    @Operation(summary = "通过id查询用户",description = "根据url的id来获取用户详细信息")
    public User getUserById(@PathVariable Long id){
        return users.get(id);
    }

    //通过id更新用户
    @PutMapping("/{id}")
    //@ApiImplicitParam(paramType = "path", dataType = "Long", name = "id", value = "用户编号", required = true, example = "1")
    @Parameter(name = "id",description = "用户编号",example = "1")
    //@ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @Operation(summary = "更新用户详细信息",description = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    public String putUserById(@PathVariable Long id,@RequestBody User user){
        User u=users.get(id);
        u.setAge(user.getAge());
        u.setName(user.getName());
        users.put(id,u);
        return "success";
    }

    //通过id删除用户
    @DeleteMapping("/{id}")
    //@ApiOperation(value="根据id删除用户",notes = "根据url的id来指定删除对象")
    @Operation(summary = "根据id删除用户",description = "根据url的id来指定删除对象")
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
    @PostMapping("/add/{id}")
    //@ApiOperation(value="根据url/add的id增加用户")
    @Operation(summary = "根据url/add的id增加用户")
    public String AddUser(@RequestBody User us){
        User user = new User();
        user = us;
        users.put(us.getId(),us);
        return "Success";
    }
}






