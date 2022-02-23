package link.enshrine.projectname.servicename.dao.model.res;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author enshrine
 */
@Data
@Accessors(chain = true)
public class DemoRes implements Serializable {

    private static final long serialVersionUID = 1L;

    private String Id;

    private String title;

    private String name;

    private Integer num;
}
