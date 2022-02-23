package link.enshrine.projectname.servicename.dao.model.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * demo表
 */
@Data
@Accessors(chain = true)
public class Demo implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 标题
     */
    private String title;

    private static final long serialVersionUID = 1L;
}