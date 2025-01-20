package mysqllearn.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: fujunli
 * @date: 2023-03-15
 */
@Setter
@Getter
@Builder
public class DmSimilarMsg {
    private String id;
    private String fromUserId;
    private String msgId1;
    private String msgId2;
    // 1：文本 2：图片
    private Integer msgType;
    private String toUserId;
    private Integer bilateral;
    private String text1;
    private String text2;
    private Double tSim;
    private String imgUrl1;
    private String imgUrl2;
    private Double aSim;
    private Double pSim;
    private String audioUrl1;
    private String audioUrl2;
    private Long sendTime1;
    private Long sendTime2;
    private Long createTimeId;
    private Date updateTime;
    private Date createTime;
}
