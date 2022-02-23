package link.enshrine.projectname.servicename.api.service;

import link.enshrine.projectname.servicename.dao.model.entity.Demo;
import link.enshrine.projectname.servicename.dao.model.req.DemoReq;
import link.enshrine.projectname.servicename.dao.model.res.DemoRes;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author enshrine
 */
public interface DemoService {
    List<DemoRes> selectDemo(DemoReq demoReq);

    List<Demo> selectAll();


}
