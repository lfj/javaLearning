package mysqllearn.entity.audit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author: jialelin
 * @date: 2022/9/16
 */
@Getter
@Setter
@ToString
public class AuditRecord {
    // 必填字段
    /**
     * 数据Id
     */
    private Long rawId;
    /**
     * 行为
     * @see
     */
    private Integer actionType;
    /**
     * 行为时间
     */
    private Long actionTime;
    /**
     * 业务线Id
     */
    private Long businessId;
    // 推审行为相关字段
    /**
     * 内容分类Id
     */
    private Long contentCategory;
    /**
     * 业务标签Id
     */
    private Integer businessTag;
    /**
     * 审核级别Id
     */
    private Integer auditLevel;
    // 审核行为相关字段
    /**
     * 操作人Id
     */
    private Long operateId;
    /**
     * 审核来源：1.分组审核 2.全部推送页 3.机器审核 4.回退上一步 5.审核记录 6.巡查 7.巡查记录
     */
    private Integer source;
    /**
     * 审核结果：1.通过 2.不通过
     */
    private Integer result;
    // 分组行为相关字段
    /**
     * 命中规则ID
     */
    private Long hitRuleId;
    /**
     * 一级分组ID
     */
    private Long firstGroupId;
    /**
     * 二级分组ID
     */
    private Long secondGroupId;

    /**
     * 记录创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 是否回调业务方：0-否，1-是，@AuditCallBackEnum
     */
    private Integer callBack;

    public static AuditRecord create(Long businessId, Long rawId, Integer actionType, Long actionTime) {
        AuditRecord auditRecord = new AuditRecord();
        auditRecord.setBusinessId(businessId);
        auditRecord.setRawId(rawId);
        auditRecord.setActionType(actionType);
        auditRecord.setActionTime(actionTime);
        auditRecord.setCreatedTime(LocalDateTime.now());
        return auditRecord;
    }
}
