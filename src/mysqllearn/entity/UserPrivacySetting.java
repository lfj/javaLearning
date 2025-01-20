package mysqllearn.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPrivacySetting {
    private String id;
    private String userId;
    private String prvcScyId;
    private Integer settingValue;
    private Integer settingType;
    private Date createTime;
    private Date updateTime;
}
