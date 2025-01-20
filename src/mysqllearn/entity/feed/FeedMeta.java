package mysqllearn.entity.feed;

import lombok.Data;

/**
 * feed元数据
 *
 * @author morgan
 * @date 2020/3/23
 */
@Data
public class FeedMeta {
    private String _id;
    private String feedId;
    private String userId;
    private String newsPic;
    private Integer imageWidth;
    private Integer imageHeight;
    private Integer imageStyle;
    private String player;
    private String playUrl;
    private String newsId;
    private int type;
    private Integer status;
    private Integer statusModifierType;
    private Long deleteTimeId;
    private Integer deleteVersion;
    private String url;
    private String title;
    private String content;
    private String picUrl;
    private String circlePosition; //object
    private String circleId;
    private String boardId;
    private String sourceFeedId;
    private String repostFeedId;
    private boolean repostIsSelfMedia;
    private String sourceCommentId;
    private Long timeId;
    private String feedLink;
    private String at;
    private String dynamicPic;
    private int tag;
    private String replyFeedId;
    private Integer sourceAppId;
    private String decoration; //object
    private String feedMap;  //object
    private String feedBuilding;  //object
    private String video;  //object
    private String qfLive;  //object
    private String sticker;
    private String extractionCode;
    private Boolean lottoFeed;
    private String fastComment;
    private String fastCommentPicId;
    private Integer circleActivityType;
    private Integer usersLimit;
    /**
     * feed动作类型
     */
    private String feedActionType;
    /**
     * feed内容类型
     */
    private String feedContentType;

    /**
     * 是否匿名 Feed
     */
    private boolean anonymous;

    private Integer anonymousType;
    private String anonymousUserName;
    private String avatar;
    private String anchorIndices; // list.object

    private String voice; // object
    /**
     * 设置的失效时间 毫秒
     */
    private Long expireMs;
    private Integer publishSource;
    private Integer subPublishSource;

    /**
     * 用户是否可以评论该feed
     */
    private Integer feedCanComment;

    /**
     * Feed 发布时的 IP 地址
     */
    private String ip;

    /**
     * Feed IP 属地
     */
    private String sourceRegion;
    /**
     * 特殊指定属地
     */
    private String spSourceRegion;
    private Integer sourceRegionType;

    /**
     * 是否仅所有者可见
     *
     * @since 5.38.0
     */
    private Boolean ownerCanSee;

    /**
     * 组局截止时间
     */
    private Long circleActivityEndTimeId;
    /**
     * 分享的story链接所对应的storyId
     */
    private String shareStoryId;
    /**
     * 纸飞机id
     */
    private String paperplaneId;
    /**
     * 纸飞机sessionId
     */
    private String sessionId;
    /**
     * 纸飞机sessionName
     */
    private String sessionName;

    /**
     * 校区id
     */
    private String schoolId;

    /**
     * 纸飞机recordId
     */
    private String sessionRecordId;

    private Long updateTimeId;
    private Integer version;

    /**
     * feed所属来源
     */
    private String appId;
}
