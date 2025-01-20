package enumlearn;

/**
 * string类型的变量转换成enum
 */
public class TransformTest {

    public static void main(String[] args) {
        try {
            String str = "China";
            RiskTypeEnum riskTypeEnum = Enum.valueOf(RiskTypeEnum.class, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
