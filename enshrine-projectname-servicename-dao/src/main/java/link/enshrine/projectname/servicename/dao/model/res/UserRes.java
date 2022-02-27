package link.enshrine.projectname.servicename.dao.model.res;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRes {
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

}
