package com.first_week.demo.web;

import com.first_week.demo.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    static Map<Long, User> users= Collections.synchronizedMap(new HashMap<Long,User>());

    //查询所有用户
    @GetMapping("/")
    public List<User> getUserList(){
        return new ArrayList<User>(users.values());
    }

    //增加用户
    @PostMapping("/")
    public String postUser(@RequestBody User user){

        users.put(user.getId(),user);
        return "success";
    }


    //通过id查询用户
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return users.get(id);
    }

    //通过id增加用户
    @PutMapping("/{id}")
    public String putUserById(@PathVariable Long id,@RequestBody User user){
        User u=users.get(id);
        u.setAge(user.getAge());
        u.setName(user.getName());
        users.put(id,u);
        return "success";
    }

    //通过id删除用户
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}






