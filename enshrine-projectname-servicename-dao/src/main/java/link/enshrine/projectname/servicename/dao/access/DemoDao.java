package link.enshrine.projectname.servicename.dao.access;

import link.enshrine.projectname.servicename.dao.model.entity.Demo;
import link.enshrine.projectname.servicename.dao.model.req.DemoReq;
import link.enshrine.projectname.servicename.dao.model.res.DemoRes;

import java.util.List;

/**
 * @author enshrine
 */
public interface DemoDao {
    List<DemoRes> selectDemo(DemoReq demoReq);

    List<Demo> selectAll();
}
