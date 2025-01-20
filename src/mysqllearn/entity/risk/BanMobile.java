package mysqllearn.entity.risk;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
@Builder
public class BanMobile {
    private Long id;
    private String mobile;
    private Date createTime;
    private Date updateTime;
    private Integer status;
    private String reason;
    private String operator;
    private Integer banType;
    private Long banTill;
    private Long banTime;
}
