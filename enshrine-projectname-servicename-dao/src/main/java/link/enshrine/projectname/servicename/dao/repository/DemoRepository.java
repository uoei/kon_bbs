package link.enshrine.projectname.servicename.dao.repository;

import link.enshrine.projectname.servicename.dao.model.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author enshrine
 */
public interface DemoRepository extends JpaRepository<Demo,String> {
}
