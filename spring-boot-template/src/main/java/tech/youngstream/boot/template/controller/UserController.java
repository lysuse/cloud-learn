package tech.youngstream.boot.template.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.youngstream.boot.template.common.JsonResult;
import tech.youngstream.boot.template.domain.User;
import tech.youngstream.boot.template.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @GetMapping("/{id}")
    public JsonResult<User> get(@PathVariable("id") Long id) {
        return JsonResult.success(userService.findById(id));
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping("")
    public JsonResult<User> add(@RequestBody User user) {
        userService.save(user.getUsername(), user.getPassword());
        return JsonResult.success(user);
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来删除用户")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "success";
    }


    @ApiOperation(value = "获取用户列表", notes = "获取所有用户列表")
    @GetMapping("")
    public List<User> list() {
        return userService.findAll().collect(Collectors.toList());
    }

}
