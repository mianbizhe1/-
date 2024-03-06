package com.first_week.demo.pojo;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
//@ApiModel(description="用户实体")
public class User {

    //@ApiModelProperty("用户编号")
    @Schema(name = "id",description = "用户id")
    private Long id;
    //@ApiModelProperty("用户姓名")
    @Schema(name="userName",description = "用户姓名")
    private String name;
    //@ApiModelProperty("用户年龄")
    @Schema(name = "userAge",description = "用户年龄")
    private Integer age;

}
