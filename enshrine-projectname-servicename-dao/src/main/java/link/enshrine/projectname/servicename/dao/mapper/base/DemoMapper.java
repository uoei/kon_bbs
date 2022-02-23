package link.enshrine.projectname.servicename.dao.mapper.base;

import java.util.List;
import link.enshrine.projectname.servicename.dao.model.dto.Demo;

public interface DemoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Demo record);

    Demo selectByPrimaryKey(String id);

    List<Demo> selectAll();

    int updateByPrimaryKey(Demo record);
}