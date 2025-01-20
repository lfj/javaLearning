package mysqllearn.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SohuTvBlackUser {

    /**
     * 数据库唯一id
     */
    private Long id;
    /**
     * 搜狐视频的数据id
     */
    private String dataId;
    /**
     * 唯一标识（设别号/手机号/用户id）
     */
    private String primaryValue;
    /**
     * 用户passport
     */
    private String passport;
    /**
     * 用户手机号码
     */
    private String mobile;
    /**
     * 狐友体系uid
     */
    private String uid;
    /**
     * 狐友体系名称
     */

    private Integer type;
    /**
     * 失效时间
     */
    private Long expireTime;
    /**
     * 封禁产品，(多个英文;隔开（COMMENT:发评论;LOGIN:登陆）)
     */
    private String product;
    /**
     * 封禁理由
     */
    private String reason;
    /**
     * 同步时间
     */
    private Long sendTime;
    /**
     * 处理状态：0：未处理，1：已删除
     */
    private Integer status;
    /**
     * 三方类型，1-tv, 2-news
     */
    private Integer sysType;
    /**
     * 操作人
     */
    private String operator;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}