package link.enshrine.projectname.servicename.dao.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户表
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 头像
     */
    private String portrait;

    /**
     * 状态 0 正常 1注销 2封禁
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}