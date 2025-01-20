package mysqllearn.entity.audit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisposalUserRecordMGD {

    private Long id;
    private Long businessId;
    private String unionId;
    private String userId;
    private Integer item;
    private Integer behavior;
    private Integer duration;
    private Integer reason;
    private Long ip;
    private String note;
    private Long operateId;
    private String operateName;
    private Long operateTime;
    private Integer source;
    private Integer callbackResult;
    private String callbackDesc;
}
