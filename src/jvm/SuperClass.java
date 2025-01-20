package jvm;

/**
 * 被动使用类字段演示一：
 * 1）通过子类引用父类的静态字段，不会导致子类初始化
 * 2）通过数组定义来引用类，不会触发此类的初始化
 * 3）
 */
public class SuperClass {

    static {
        System.out.println("super class init!");
    }

    public static int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("subclass init!");
    }
}

class NotInitialization {
    public static void main(String[] args) {
        //System.out.println(SubClass.value);
        SuperClass[] sca = new SuperClass[0];
    }
}
