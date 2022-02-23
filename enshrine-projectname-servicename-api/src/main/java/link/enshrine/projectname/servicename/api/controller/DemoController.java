package link.enshrine.projectname.servicename.api.controller;

import link.enshrine.framework.common.config.Result;
import link.enshrine.framework.common.exception.DemoException;
import link.enshrine.projectname.servicename.api.service.DemoService;
import link.enshrine.projectname.servicename.dao.model.entity.Demo;
import link.enshrine.projectname.servicename.dao.model.req.DemoReq;
import link.enshrine.projectname.servicename.dao.model.res.DemoRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author enshrine
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @PostMapping("/selectDemo")
    public Result<List<DemoRes>> selectDemo(@RequestBody DemoReq demoReq){
        try {
            log.info("[查询Demo]服务 调用开始");
            List<DemoRes> demoResList = demoService.selectDemo(demoReq);
            log.info("[查询Demo]服务 调用成功");
            return Result.success(demoResList);
        }catch (Exception e){
            throw new DemoException("[查询Demo]服务 调用失败", e);
        }
    }

    @PostMapping("/selectAll")
    public Result<List<Demo>> selectDemo(){
        try {
            log.info("[查询Demo]服务 调用开始");
            List<Demo> demoList = demoService.selectAll();
            log.info("[查询Demo]服务 调用成功");
            return Result.success(demoList);
        }catch (Exception e){
            throw new DemoException("[查询Demo]服务 调用失败", e);
        }
    }
}
