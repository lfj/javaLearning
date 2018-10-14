package aop;

public class AdviceImpl implements Advice {
    public void firstMethod() {
        System.out.println("==fristMethod==");
    }

    public String secondMethod() {
        System.out.println("==secondMethod==");
        return "abc";
    }
}
