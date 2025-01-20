package mysqllearn.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PermLock {
    private Long id;
    private String userId;
    private String condition;
    private Long lockTime;
    private Long lockTill;
    private Integer permType;
    private Integer lockType;
    private Integer reason;
    private String comment;
    private Integer status;
}
