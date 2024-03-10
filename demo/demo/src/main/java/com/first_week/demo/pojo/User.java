package com.first_week.demo.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
//@ApiModel(description="用户实体")
public class User implements Serializable {

    //@ApiModelProperty("用户编号")
    @Schema(name = "id",description = "用户id")
    private Long Id;
    //@ApiModelProperty("用户姓名")
    @Schema(name="userName",description = "用户姓名")
    private String Name;
    //@ApiModelProperty("用户年龄")
    @Schema(name = "userAge",description = "用户年龄")
    private Integer Age;

}
