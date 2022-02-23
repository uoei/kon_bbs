package link.enshrine.projectname.servicename.dao.mapper.base;

import java.util.List;
import link.enshrine.projectname.servicename.dao.model.dto.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    User selectByPrimaryKey(String id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}