package mysqllearn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author zhangaichong on 2019/9/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SnsFeedback {

    private Integer id;

    private String trackId;

    private String fuid;

    private String duid;

    private Integer source;

    private Integer type;

    private Integer feedbackType;

    private String cause;

    private String imgs;

    private String feedId;

    private String repostUserId;

    private String repostFeedId;

    private String commentFeedId;

    private String commentId;

    private String messageId;

    private String auditor;
    /**
     * 处理状态：0未处理，1已处理
     */
    private Integer handleStatus;
    private Integer handleResult;
    private Integer rejectReason;
    /**
     * 投诉结果，0不成功，1成功
     */
    private Integer status;
    private Long handleTime;
    private Date createTime;
    private Date updateTime;
}
