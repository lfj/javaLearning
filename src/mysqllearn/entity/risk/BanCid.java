package mysqllearn.entity.risk;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class BanCid {
    private Long id;
    private String suid;
    private String cid;
    private Date createTime;
    private Date updateTime;
    private Integer status;
    private String reason;
    private String operator;
}
