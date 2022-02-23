package link.enshrine.projectname.servicename.api.controller;

import link.enshrine.framework.common.config.Result;
import link.enshrine.framework.common.exception.DemoException;
import link.enshrine.projectname.servicename.api.service.UserService;
import link.enshrine.projectname.servicename.dao.model.req.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final UserService userService;

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
}
