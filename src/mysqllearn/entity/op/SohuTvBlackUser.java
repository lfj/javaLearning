package mysqllearn.entity.op;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SohuTvBlackUser {
    private Long id;
    private String dataId;
    private String primaryValue;
    private String passport;
    private String mobile;
    private String uid;
    private String name;
    private Integer type;
    private Long expireTime;
    private String product;
    private String reason;
    private Long sendTime;
    private Integer status;
    private Integer sysType;
    private String operator;
    private Date createTime;
    private Date updateTime;
}