package link.enshrine.projectname.servicename;

import link.enshrine.framework.common.utils.ResourcesUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication(scanBasePackages = "link.enshrine")
@ComponentScan(basePackages = {"link.enshrine"})
@MapperScan({"link.enshrine.**.mapper"})
@Slf4j
public class ApplicationRun {
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationRun.class, args);
        ConfigurableEnvironment environment = context.getEnvironment();
        String result = "";
        try {
            result = ResourcesUtil.getStartImg();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        log.info(result + "\n--------------------------------------------------------------------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}\n\t" +
                        "External: \thttp://{}:{}\n--------------------------------------------------------------------------------------------------------------------",
                "Blog-System",
                environment.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                environment.getProperty("server.port"));
    }
}
