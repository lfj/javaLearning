package abstractclasslearn;

public class Man extends People {

    public static void  judgePeople() {
        System.out.println("Man类的方法被调用！");
    }

    public static void main(String[] args) {
        People.judgePeople();
    }
}
