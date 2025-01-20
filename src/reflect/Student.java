package reflect;

import lombok.Data;

@Data
public class Student {
    private String sid;

    private String sname;

    public Integer age;

    static{
        System.out.println("加载进jvm中！");
    }

    public Student() {
        super();
        System.out.println("调用无参构造方法创建了一个学生对象");
    }

    public Student(String sid) {
        super();
        this.sid = sid;
        System.out.println("调用带一个参数的构造方法创建了一个学生对象");
    }

    public Student(String sid, String sname) {
        super();
        this.sid = sid;
        this.sname = sname;
        System.out.println("调用带二个参数的构造方法创建了一个学生对象");
    }

    @SuppressWarnings("unused")
    private Student(Integer age) {
        System.out.println("调用Student类私有的构造方法创建一个学生对象");
        this.age = age;
    }

    public void hello() {
        System.out.println("你好！我是" + this.sname);
    }

    public void hello(String name) {
        System.out.println(name + "你好！我是" + this.sname);
    }

    @SuppressWarnings("unused")
    private Integer add(Integer a, Integer b) {
        return new Integer(a.intValue() + b.intValue());
    }

    public static void main(String[] args) {

    }
}
