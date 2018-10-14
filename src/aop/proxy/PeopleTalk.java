package aop.proxy;

/**
 * 真实主题角色，定义真实的对象
 */
public class PeopleTalk implements ITalk {

    public String userName;

    public String age;

    public PeopleTalk(String userName, String age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public void talk(String msg) {
        System.out.println(msg + "!你好，我是" + userName + "，我年龄是" + age);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
