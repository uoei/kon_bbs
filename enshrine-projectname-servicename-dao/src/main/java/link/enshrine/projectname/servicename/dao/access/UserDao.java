package link.enshrine.projectname.servicename.dao.access;

import link.enshrine.projectname.servicename.dao.model.dto.User;
import link.enshrine.projectname.servicename.dao.model.req.UserReq;

public interface UserDao {

    void addUser(UserReq userReq);

    User selectUserByUsername(String username);
}
