package link.enshrine.projectname.servicename.dao.mapper.extend;

import link.enshrine.projectname.servicename.dao.mapper.base.DemoMapper;
import link.enshrine.projectname.servicename.dao.model.req.DemoReq;
import link.enshrine.projectname.servicename.dao.model.res.DemoRes;

import java.util.List;

public interface DemoExtendMapper extends DemoMapper {
    List<DemoRes> selectDemo(DemoReq demoReq);
}