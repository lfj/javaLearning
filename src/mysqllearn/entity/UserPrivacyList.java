package mysqllearn.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPrivacyList {
    private String id;
    private String userId;
    private String prvcUserId;
    private String prvcScyId;
    private String updateTime;
    private String createTime;
    private Long createTimeId;
}
