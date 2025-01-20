package mysqllearn.entity.risk;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * feed处置记录
 * @author jialelin
 * @since 2022/11/17
 */
@Data
public class FeedDisposeRecord {
    private String feedId;
    private String feed;
    private String simFeeds;
    private String disposeReason;
    private String disposeResult;
    private String handledContent;
    private String remark;
    private String keywords;
    private LocalDateTime createdTime;
    private Long createTimeId;
}
