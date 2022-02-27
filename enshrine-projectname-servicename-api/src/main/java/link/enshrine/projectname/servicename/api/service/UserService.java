package link.enshrine.projectname.servicename.api.service;

import link.enshrine.projectname.servicename.dao.model.req.UserReq;
import link.enshrine.projectname.servicename.dao.model.res.UserRes;

public interface UserService {

     void register(UserReq userReq) ;

    UserRes login(UserReq userReq);
}
