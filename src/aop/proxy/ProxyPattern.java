package aop.proxy;

/**
 * 代理测试类，使用代理
 */
public class ProxyPattern {

    public static void main(String[] args) {
        /* 不需要执行额外的方法 */
        ITalk people = new PeopleTalk("AOP", "18");
        people.talk("No proxy test");
        System.out.println("---------------------------");

        /* 需要额外执行的方法 */
        TalkProxy talkProxy = new TalkProxy(people);
        talkProxy.talk("proxy test", "代理");
    }
}
