package mysqllearn.entity.audit;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AuditResult {
    private Long id;
    private Long businessId;
    private Long rawId;
    private Long contentCategory;
    private Long auditLevel;
    private Long businessTag;
    private Integer source;
    private Integer result;
    private Long operateId;
    private Date operateTime;
    private Date createTime;
    private Date updateTime;
}
