package link.enshrine.projectname.servicename.api.controller;

import link.enshrine.framework.common.config.Result;
import link.enshrine.framework.common.exception.DemoException;
import link.enshrine.projectname.servicename.api.service.UserService;
import link.enshrine.projectname.servicename.dao.model.dto.User;
import link.enshrine.projectname.servicename.dao.model.req.UserReq;
import link.enshrine.projectname.servicename.dao.model.res.UserRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController (UserService userService){this.userService=userService;}
    @PostMapping("/register")
    public Result<Void> register(@RequestBody UserReq userReq){

        try {
            userService.register(userReq);
            return Result.success();
        }catch (Exception e){
            throw new DemoException("[注册]服务 调用失败", e);
        }

    }
    @PostMapping("/login")
    public Result<UserRes> login(@RequestBody UserReq userReq){

        try {
            log.info("[登录]服务 调用开始");
            return Result.success(userService.login(userReq));
        }catch (Exception e){
            throw new DemoException("[登录]服务 调用失败", e);
        }

    }
}
