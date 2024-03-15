package com.first_week.demo.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@TableName("user")
@ToString
public class UserDTO implements Serializable {

    private Integer id;


    private String name;


    private Integer age;
}
