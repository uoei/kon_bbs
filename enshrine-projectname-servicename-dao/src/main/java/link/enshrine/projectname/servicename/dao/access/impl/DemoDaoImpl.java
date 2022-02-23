package link.enshrine.projectname.servicename.dao.access.impl;

import link.enshrine.projectname.servicename.dao.access.DemoDao;
import link.enshrine.projectname.servicename.dao.mapper.extend.DemoExtendMapper;
import link.enshrine.projectname.servicename.dao.model.entity.Demo;
import link.enshrine.projectname.servicename.dao.model.req.DemoReq;
import link.enshrine.projectname.servicename.dao.model.res.DemoRes;
import link.enshrine.projectname.servicename.dao.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author enshrine
 */
@Repository
public class DemoDaoImpl implements DemoDao {

    private final DemoExtendMapper demoExtendMapper;
    private final DemoRepository demoRepository;

    @Autowired
    public DemoDaoImpl(DemoExtendMapper demoExtendMapper, DemoRepository demoRepository) {
        this.demoExtendMapper = demoExtendMapper;
        this.demoRepository = demoRepository;
    }

    @Override
    public List<DemoRes> selectDemo(DemoReq demoReq) {
        return demoExtendMapper.selectDemo(demoReq);
    }

    @Override
    public List<Demo> selectAll() {
        return demoRepository.findAll();
    }
}
