package link.enshrine.projectname.servicename.dao.mapper.extend;

import link.enshrine.projectname.servicename.dao.mapper.base.UserMapper;
import link.enshrine.projectname.servicename.dao.model.dto.User;
import link.enshrine.projectname.servicename.dao.model.req.UserReq;

public interface UserExtendMapper extends UserMapper {
    void addUser(UserReq userReq);
    User selectUserByUsername(String username);

}