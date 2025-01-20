package redisclienteval;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class CircleActivity {
    private Long id;
    private String circleId;
    private String userId;
    private String activityId;
    private Integer activityType;
    private Integer usersLimit;
    private Integer memberNum;
    private String description;
    private Long endTimeId;
    private CircleActivityStatus status;
    private String dynamicPic;
    private Long createTimeId;
}
enum CircleActivityStatus {
    /**
     * 未知
     */
    UNKNOWN(0),
    /**
     * 正常
     */
    NORMAL(1),
    /**
     * 审核中
     */
    AUDITING(2),
    /**
     * 审核失败
     */
    AUDIT_FAIL(3),
    /**
     * 已过期
     */
    @Deprecated
    EXPIRED(4);

    private final int code;

    CircleActivityStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static CircleActivityStatus valueOf(int value) {
        switch (value) {
            case 1:
                return NORMAL;
            case 2:
                return AUDITING;
            case 3:
                return AUDIT_FAIL;
            default:
                return UNKNOWN;
        }
    }
}

