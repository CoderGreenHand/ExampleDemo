package com.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value="/",tags ={"这是我全部的post请求"} )
@RequestMapping("/controller")
public class PostController {
    private static Cookie cookie;
    //@RequestMapping(value="/login",method = RequestMethod.POST)
    @PostMapping(value="/login",headers = "name",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="登录接口，成功后获取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response, @RequestParam(value="userName",required = true) String username,
                        @RequestParam(value="passWord",required = true) String password){
        if(username.equals("root")&&password.equals("root123")){
            cookie = new Cookie("login","success");
            response.addCookie(cookie);
            return "恭喜你登录成功";
        }
        return "用户名或密码错误";
    }


}
