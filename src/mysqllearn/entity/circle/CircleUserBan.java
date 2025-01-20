package mysqllearn.entity.circle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 圈子用户禁言表
 *
 * @author fujunli
 * @date 2022-01-27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CircleUserBan {
    private String id;
    private String circleId;
    private String userId;
    private String passport;
    private Integer banType;
    private String feedId;
    private Integer banDuration;
    private Integer reason;
    private String reasonContent;
    private String note;
    private String operatorId;
    private Long startTimeId;
    private Long endTimeId;
    private Long unlockTimeId;
    private Date createTime;
    private Date updateTime;
}