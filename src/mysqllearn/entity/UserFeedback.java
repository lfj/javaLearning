package mysqllearn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 用户反馈数据
 * @author jialelin
 * @since 2023/05/16
 */
public class UserFeedback {
    /**
     * 记录唯一标识
     */
    private String dataId;
    /**
     * 投诉人Id
     */
    private String fuid;
    /**
     * 被投诉人Id
     */
    private String duid;
    /**
     * 投诉来源
     * @see Source
     */
    private Integer source;
    /**
     * 投诉类型
     * @see Type
     */
    private Integer type;
    /**
     * 投诉对象
     * @see FeedbackType
     */
    private Integer feedbackType;
    /**
     * 投诉原因
     */
    private String cause;
    /**
     * 投诉截图
     */
    private String imgs;
    /**
     * 被评论的feedId
     */
    private String commentFeedId;
    /**
     * 评论Id
     */
    private String commentId;
    /**
     * feedId
     */
    private String feedId;
    /**
     * 被转发的feedId
     */
    private String repostFeedId;
    /**
     * 被转发的feed的用户Id
     */
    private String repostUserId;
    /**
     * 私信Id
     */
    private String messageId;
    /**
     * 是否处置成功
     * @see Status
     */
    private Integer status;
    /**
     * 处理结果
     * @see HandleResult
     */
    private Integer handleResult;
    /**
     * 投诉不成功理由
     * @see RejectReason
     */
    private Integer rejectReason;
    /**
     * 反馈时间
     */
    private Long feedbackTimeId;
    /**
     * 处理时间
     */
    private Long handleTimeId;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    public void modified(Integer status, Integer handleResult, Integer rejecetReason, Long handleTimeId) {
        this.status = status;
        this.handleResult = handleResult;
        this.rejectReason = rejecetReason;
        this.handleTimeId = handleTimeId;
        this.modifiedTime = LocalDateTime.now();
    }

    @Getter
    @AllArgsConstructor
    enum Source {

        APP(0),
        MINI(1);

        private int value;
    }

    @Getter
    @AllArgsConstructor
    enum Type {

        OTHER(0,"其他"),
        GUANG_GAO(1,"垃圾广告"),
        SE_QING(2,"淫秽色情"),
        E_YI_SAO_RAO(3,"恶意骚扰"),
        SI_XIN_SAO_RAO(4,"私信骚扰"),
        SHE_ZHENG_BAO_KONG(5,"涉政暴恐"),
        YING_XIAO(6,"营销活动"),
        WEI_CHENG_NIAN(7,"涉未成年人"),
        FAN_QUAN(8,"饭圈违规"),
        MAN_MA(9,"谩骂攻击"),
        QIN_FAN(10,"侵犯人身权利");

        private int value;
        private String desc;
    }

    @Getter
    @AllArgsConstructor
    public enum FeedbackType {

        USER(0),
        CIRCLE(1),
        COMMENT(2),
        FEED(3),
        DM(4);

        private int value;
    }

    @Getter
    @AllArgsConstructor
    public enum Status {

        FAIL(0),
        SUCCESS(1);

        private int value;
    }

    @Getter
    @AllArgsConstructor
    public enum HandleResult {

        NONE(1,"不处理"),
        DELETE(2,"删除评论/Feed"),
        DM_BAN(4,"私信封禁"),
        INTERACTION_BAN(8,"互动封禁"),
        CIRCLE_DISPOSED(16,"圈子已处理"),
        HIDE(32,"隐藏评论");

        private int value;
        private String desc;
    }

    @Getter
    @AllArgsConstructor
    enum RejectReason {
        INSUFFICIENT(0,"投诉理由不充分"),
        NEED_IDENTITY_INFO(1,"需补充身份信息"),
        NEED_EVIDENCE(2,"需提供相关证据");

        private int value;
        private String desc;
    }
}
