package mysqllearn.entity.risk;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

/**
 * @author morganyoung
 * @since 2023/3/22
 */
@Getter
@Setter
@ToString
public class RegisterInfo {
    private String userId;
    private String passportId;
    private String mobile;
    private String cid;
    private String appid;
    private String ip;
    private Long timeId;
    private Boolean unReg;
    private Date createdTime;
}
