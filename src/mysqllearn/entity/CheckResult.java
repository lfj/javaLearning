package mysqllearn.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author jy
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckResult {
    private String businessId;
    private String dataId;
    private String userId;
    /**
     * 纯文本请求
     */
    private String textRequest;
    private String textRawYiDunResponse;
    /**
     * 图片请求
     */
    private String imageRequests;
    private String imageRawYiDunResponse;
    /**
     * 语音请求
     */
    private String audioRequest;
    private String audioRawYiDunResponse;
}
