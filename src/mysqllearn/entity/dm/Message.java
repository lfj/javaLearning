package mysqllearn.entity.dm;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Message {
    private Integer id;
    private String sendTime;
    private String fromUserId;
    private String toUserId;
    private String msg;
    private String imgSmallName;
    private String imgSmallUrl;
    private String imgName;
    private String imgUrl;
    private Integer type;
    private Integer dialogId;
    private String imgSmallH;
    private String imgSmallW;
    private String imgOriginalName;
    private Integer imgOriginalSize;
    private String imgOriginalUrl;
    private Integer status;
    private Long audioId;
    private Long feedId;
    private Long groupId;
    private Long groupMessageId;
    private Long stickerId;
    private Long redPacketId;
    private String circleId;
    private String conversationId;
    private Long msgUpdateTime;
    private Long msgId;
}
