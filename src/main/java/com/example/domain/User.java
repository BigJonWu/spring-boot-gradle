package com.example.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@ApiModel
public class User implements Serializable {

    private int id;

    @NotNull(message = "名字不能为空")
    @ApiModelProperty(value = "名字", example = "Jon", required = true)
    private String name;

    @Max(value = 120, message = "年龄最大不能查过120")
    private int age;

    @Email(message = "邮箱格式错误")
    private String email;
}
