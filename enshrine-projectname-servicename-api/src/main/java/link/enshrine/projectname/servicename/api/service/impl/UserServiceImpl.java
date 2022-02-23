package link.enshrine.projectname.servicename.api.service.impl;

import link.enshrine.projectname.servicename.api.service.UserService;
import link.enshrine.projectname.servicename.dao.access.UserDao;
import link.enshrine.projectname.servicename.dao.model.req.UserReq;
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
}
