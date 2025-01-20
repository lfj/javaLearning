package mysqllearn.entity.audit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: jqx
 * @date: 2022/9/13
 */
@Getter
@Setter
@ToString
public class AuditContent {

    private Long rawId;
    private Long businessId;
    private Long receiveTime;
    private Long contentCategory;
    private String dataVersion;
    private String dataId;
    private String dataParentId;
    private Integer dataAuditLevel;
    private String circleId;
    private String groupChatId;
    private String topicId;
    private Integer dataBusinessTag;
    private Long dataPublishTime;
    private String dataCallbackContent;
    private String dataExtra;
    private String dataMainPostId;
    private String dataSourceUrl;
    private String dataSourceTitle;
    private String dataItems;
    private String publisherUnionId;
    private String publisherId;
    private String publisherName;
    private String publisherImage;
    private String publisherIP;
    private String publisherAddress;
    private String publisherDeviceId;
    private String publisherMobile;
    private String targetId;
    private Long auditFirstGroupId;
    private Long auditSecondGroupId;
    private List keywordIds;
    private Long auditHitRuleId;
    private String auditHitRuleName;
    private String auditHitKeywords;
    private String auditHitTagNames;
    private String auditHitMediaTypes;
    private String auditHitItems;
    private Integer auditHitReason;
    private Integer auditPriority;
    private Integer auditResult;
    private Long auditOperateTime;
    private Long auditOperatorId;
    private Integer auditSource;
    private String auditReason;
    private String auditRecords;
    private Long firstAuditTime;
    private Long distributeTime;
    private Integer cobraResult;
    private String cobraStrategyId;
    private String cobraRuleCode;
    private Double cobraRuleScore;
    private Long version;
    private LocalDateTime modifiedTime;
    private LocalDateTime createdTime;
    private List showInfo;
    private Integer firstGarbageTypeCode;
    private LocalDateTime garbageTypeSetTime;
}
