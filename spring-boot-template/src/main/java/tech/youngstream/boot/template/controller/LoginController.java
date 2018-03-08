package tech.youngstream.boot.template.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import tech.youngstream.boot.template.service.UserService;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录", notes = "用户名密码登录")
    @PostMapping("/login")
    public ModelAndView login(String username, String password) {
        String page = "index";
        if(!userService.login(username, password)) {
            page = "error";
        }
        return new ModelAndView(page);
    }

}
