package link.enshrine.projectname.servicename.api.service.impl;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import link.enshrine.framework.common.exception.DemoException;
import link.enshrine.projectname.servicename.api.service.UserService;
import link.enshrine.projectname.servicename.api.utils.TokenUtils;
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
        User user = userDao.selectUserByUsername(userReq.getUsername());
        if (user != null) {
            throw new DemoException("用户名已存在");
        }
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
        String token = TokenUtils.generateToken(user);
        userRes.setToken(token);

        RedisClient redisClient = RedisClient.create("redis://124.223.71.190:6371");
        StatefulRedisConnection<String, String> connect = redisClient.connect();
        RedisCommands<String, String> syncCommands = connect.sync();




        syncCommands.hset("token",user.getUsername(),token);
        connect.close();
        redisClient.shutdown();

        return userRes;
    }
}
