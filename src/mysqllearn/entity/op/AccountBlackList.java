package mysqllearn.entity.op;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;
/**
 * @author kevinzou
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountBlackList {
    private Integer id;
    private String userId;
    private String userName;
    private String passport;
    private String mobile;
    private String currentCid;
    private Integer status;
    private Integer blockType;
    private String blockReason;
    private String operator;
    private String memo;

    /**
     * 是否是临时封禁记录
     */
    private Integer isTempBan;
    /**
     * 用户所在圈子id
     */
    private String circleId;
    /**
     * 封禁天数
     */
    private Integer banDuration;

    /**
     * 封禁时间(时间戳)
     */
    private Long banTime;

    /**
     * 解封时间(时间戳)
     */
    private Long unbanTime;
    private Date createTime;
    private Date updateTime;

}