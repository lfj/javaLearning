package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import static java.lang.System.out;

public class Constructors {
    public static void main(String[] args) {
        try {
            /* 加载Class对象 */
            Class stuClass = Class.forName("reflection.Student");

            /* 获取所有公共构造方法 */
            out.println("*******************所有公共构造方法*******************");
            Constructor[] conArray = stuClass.getConstructors();
            for (Constructor c: conArray) {
                out.println(c);
            }

            /* 获取所有的字段 */
            Field[] fieldArray = stuClass.getFields();
            for (Field field: fieldArray) {
                out.println(field);
            }

            /* 获取公有字段并调用 */
            Field f = stuClass.getField("name");
            Object stuObject = stuClass.getConstructor().newInstance();
            f.set(stuObject, "刘德华");
            out.println(f);
            Student stu = (Student)stuObject;
            out.println("验证姓名：" + stu.name);
            out.println("验证学生ID：" + stu.id);
            out.println("验证国家：" + stu.nation);

            /* 获取私有字段并调用 */
            f = stuClass.getDeclaredField("age");
            f.setAccessible(true); /* 暴力反射，解除私有限定 */
            f.set(stuObject, "18");
            System.out.println(f);
            System.out.println("学生信息" + (Student)stuObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
