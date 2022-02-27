package link.enshrine.projectname.servicename.api.service.impl;

import link.enshrine.framework.common.exception.DemoException;
import link.enshrine.projectname.servicename.api.service.UserService;
import link.enshrine.projectname.servicename.dao.access.UserDao;
import link.enshrine.projectname.servicename.dao.model.dto.User;
import link.enshrine.projectname.servicename.dao.model.req.UserReq;
import link.enshrine.projectname.servicename.dao.model.res.UserRes;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(UserReq userReq) {
        String uuid = UUID.randomUUID().toString();
        userReq.setId(uuid);
        userDao.addUser(userReq);
    }

    @Override
    public UserRes login(UserReq userReq) {
        UserRes userRes=null;
        //后端通过username查询user是否存在 userReq.getUsername()前端的值
        User user = userDao.selectUserByUsername(userReq.getUsername());
        if(user==null){
            throw new DemoException("用户名不存在");
        }
        if(!user.getPassword().equals(userReq.getPassword())){
            throw new DemoException("密码错误");
        }
        userRes = new UserRes();
        BeanUtils.copyProperties(user,userRes);
        return userRes;
    }
}
