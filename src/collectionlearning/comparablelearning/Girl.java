package collectionlearning.comparablelearning;

import java.util.TreeSet;

/**
 * 重写compareTo方法实现按颜值来进行排序
 */
public class Girl implements Comparable<Girl> {

    private String name;

    private int age;

    private int appearence;/* 颜值 */

    public Girl(String name, int age, int appearence) {
        this.name = name;
        this.age = age;
        this.appearence = appearence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAppearence() {
        return appearence;
    }

    public void setAppearence(int appearence) {
        this.appearence = appearence;
    }

    @Override
    public int compareTo(Girl o) {
        if (this.appearence > o.appearence) {
            return 1;
        } else if (this.appearence < o.appearence) {
            return -1;
        }
        return this.appearence;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", appearence=" + appearence +
                '}';
    }

    public static void main(String[] args) {
        TreeSet<Girl> girls = new TreeSet();
        girls.add(new Girl("lyp", 24, 5));
        girls.add(new Girl("crt", 23, 7));
        girls.add(new Girl("lyj", 25, 6));
        girls.add(new Girl("lmf", 25, 3));
        girls.add(new Girl("fengjie", 38, -1));
        girls.add(new Girl("liyifei", 40, 10));
        for (Girl girl : girls) {
            System.out.println(girl.toString());
        }
    }
}
