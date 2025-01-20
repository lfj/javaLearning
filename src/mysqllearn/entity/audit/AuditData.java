package mysqllearn.entity.audit;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AuditData {
    private Long id;
    private Long businessId;
    private Long contentCategory;
    private Long rawId;
    private Integer result;
    private Integer source;
    private Integer reason;
    private Long operateId;
    private Date operateTime;
    private Date createTime;
    private Date updateTime;
    private Integer version;
}
