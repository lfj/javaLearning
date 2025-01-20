package mysqllearn.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: jqx
 * @date: 2022/12/22
 */
@Setter
@Getter
public class TencentRCEData {

    private String _id;
    private String userId;
    private String cid;
    private Integer vocabId;
    private String sceneCode;
    private String requestId;
    private String riskLevel;
    private String rawReq;
    private String rawResp;
    private String createdTime;
    private String mobile;
    private String rip;
}