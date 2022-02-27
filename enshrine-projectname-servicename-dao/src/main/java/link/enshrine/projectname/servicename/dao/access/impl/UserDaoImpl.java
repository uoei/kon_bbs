package link.enshrine.projectname.servicename.dao.access.impl;

import link.enshrine.projectname.servicename.dao.access.UserDao;
import link.enshrine.projectname.servicename.dao.model.dto.User;
import link.enshrine.projectname.servicename.dao.model.req.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import link.enshrine.projectname.servicename.dao.mapper.extend.UserExtendMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    private final UserExtendMapper userExtendMapper;
    @Autowired
    public UserDaoImpl(UserExtendMapper userExtendMapper) {
        this.userExtendMapper = userExtendMapper;
    }

    @Override
    public void addUser(UserReq userReq) {
        userExtendMapper.addUser(userReq);
    }

    @Override
    public User selectUserByUsername(String username) {
        return userExtendMapper.selectUserByUsername(username);
    }
}
