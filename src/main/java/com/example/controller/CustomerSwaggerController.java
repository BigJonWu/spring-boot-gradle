package com.example.controller;

import com.example.domain.User;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * 实验Swagger API
 */
@RestController
@RequestMapping(value = "/swtest")
@Api(tags = "Swagger+Springboot搭建API", description = "API", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerSwaggerController {

//    @Api：修饰整个类，描述Controller的作用
//    @ApiOperation：描述一个类的一个方法，或者说一个接口
//    @ApiParam：单个参数描述
//    @ApiModel：用对象来接收参数
//    @ApiProperty：用对象接收参数时，描述对象的一个字段
//    @ApiResponse：HTTP响应其中1个描述
//    @ApiResponses：HTTP响应整体描述
//    @ApiIgnore：使用该注解忽略这个API
//    @ApiError ：发生错误返回的信息
//    @ApiParamImplicitL：一个请求参数
//    @ApiParamsImplicit 多个请求参数

    @ApiOperation(value = "获用户详细信息", notes = "根据url的id来获取详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        //@PathVariable用于将请求URL中的模板变量映射到功能处理方法的参数上。//配置url和方法的一个关系@RequestMapping("item/{itemId}")
        User user = new User();
        user.setId(id);
        user.setAge(29);
        user.setName("springboot");
        return user;
    }

    @ApiOperation(value = "User信息保存")
    @RequestMapping(value = "/setuser", method = RequestMethod.POST)  //, produces = "application/json"
    //@ResponseBody
    public String setUser(@Valid @RequestBody User user, BindingResult result) {
        if (result != null && result.hasErrors()) {
            StringBuilder errorMessageBuilder = new StringBuilder();
            result.getAllErrors().forEach(error -> errorMessageBuilder.append("[").append(error.getObjectName())
                    .append("-").append(error.getDefaultMessage()).append("]"));

            return errorMessageBuilder.toString();
        } else {
            return user.toString();
        }
    }
}
