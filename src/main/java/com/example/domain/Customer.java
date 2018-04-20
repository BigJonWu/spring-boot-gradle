package com.example.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    private int id;

    @NotNull(message = "名字不能为空")
    @ApiModelProperty(value = "名字", example = "Jon", required = true)
    private String name;

    @Max(value = 120, message = "年龄最大不能查过120")
    private int age;

    @Email(message = "邮箱格式错误")
    private String email;

    @ApiModelProperty(value = "生日", example = "1990-01-01", required = true)
    private Date birthDay;
}
