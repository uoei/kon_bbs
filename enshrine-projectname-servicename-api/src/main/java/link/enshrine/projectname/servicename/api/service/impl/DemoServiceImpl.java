package link.enshrine.projectname.servicename.api.service.impl;

import link.enshrine.projectname.servicename.api.service.DemoService;
import link.enshrine.projectname.servicename.dao.access.DemoDao;
import link.enshrine.projectname.servicename.dao.model.entity.Demo;
import link.enshrine.projectname.servicename.dao.model.req.DemoReq;
import link.enshrine.projectname.servicename.dao.model.res.DemoRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author enshrine
 */
@Service
public class DemoServiceImpl implements DemoService {

    private final DemoDao demoDao;

    @Autowired
    public DemoServiceImpl(DemoDao demoDao) {
        this.demoDao = demoDao;
    }

    @Override
    public List<DemoRes> selectDemo(DemoReq demoReq) {
        return demoDao.selectDemo(demoReq);
    }

    @Override
    public List<Demo> selectAll() {
        return demoDao.selectAll();
    }

}
