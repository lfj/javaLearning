package mysqllearn.entity.op;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OpFeedOperatingLog {
    private Long id;
    private String feedId;
    private Integer type;
    private Integer source;
    private String operator;
    private Date operatorTime;
    private Date createTime;
    private Date updateTime;
}