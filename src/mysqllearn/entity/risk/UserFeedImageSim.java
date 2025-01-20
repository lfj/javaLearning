package mysqllearn.entity.risk;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class UserFeedImageSim {

    private String id;
    private String userId;
    private String feedId1;
    private String feedId2;
    private String imgUrl1;
    private String imgUrl2;
    private double aSim;
    private double pSim;
    private Date createTime;
}
