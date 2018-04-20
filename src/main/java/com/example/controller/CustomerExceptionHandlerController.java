package com.example.controller;

import com.example.domain.Customer;
import com.example.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/ex")
@Api(tags = "ExceptionTestAPI", description = "API", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerExceptionHandlerController {

    @ApiOperation(value = "获用户详细信息", notes = "根据url的id来获取详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET)
    public Customer getUser(@PathVariable int id) {
        throw new BusinessException("该ID不存在");
    }


    @ApiOperation(value = "User信息保存")
    @RequestMapping(value = "/setuser", method = RequestMethod.POST)
    public String setUser(@Valid @RequestBody Customer user, BindingResult result) {
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
