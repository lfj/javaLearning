package aop.proxy;

/**
 * 代理主题角色：内部包含对真实主题的引用，并且提供和真实主题角色相同的接口
 */
public class TalkProxy implements ITalk {

    private ITalk talker;

    public TalkProxy(ITalk talker) {
        this.talker = talker;
    }

    @Override
    public void talk(String msg) {
        talker.talk(msg);
    }

    public void talk(String msg, String singName) {
        talker.talk(msg);
        sing(singName);
    }

    private void sing(String singName) {
        System.out.println("唱歌：" + singName);
    }
}
