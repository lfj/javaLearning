package mysqllearn.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author morganyoung
 * @since 2022/10/29
 */
@Getter
@Setter
public class ContentMarkResult {
    private String feedId;
    private String userId;
    private String content;
    private int feedType;
    private long timeId;
    private Date createTime;
    private List<MarkResult> markResultList;

    @Getter
    @Setter
    public static class MarkResult {
        private List<Integer> labels;
        private List<Integer> levels;
        private List<Double> rates;
        private List<String> hints;
        private List<Integer> subLabels;
        private String content;
        private String contentType;
        private String auditor;
    }

    public boolean hasLabels(Set<Integer> labelSet) {
        if (getMarkResultList() == null) {
            return false;
        }
        for (MarkResult markResult : getMarkResultList()) {
            if (markResult.getLabels() == null || markResult.getLabels().isEmpty()) {
                continue;
            }
            for (Integer label : markResult.getLabels()) {
                if (labelSet.contains(label)) {
                    return true;
                }
            }
        }
        return false;
    }
}
