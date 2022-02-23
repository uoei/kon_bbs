package link.enshrine.projectname.servicename.dao.model.entity;

import link.enshrine.framework.jpa.annotation.Comment;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Comment("demo表")
@Table(name = "demo")
public class Demo {

    @Id
    @Column(length = 36, nullable = false)
    @Comment("主键")
    @GenericGenerator(name = "id", strategy = "uuid2")
    @GeneratedValue(generator = "id")
    private String id;

    @Column(name = "title", nullable = false, unique = true, length = 30)
    @Comment("标题")
    private String title;

    @Column(name = "name", nullable = false, length = 20)
    @Comment("名称")
    private String name;

    @Column(name = "num")
    @Comment("数量")
    private Integer num;
}
