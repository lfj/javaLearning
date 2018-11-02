package designpattern.proxydesign;

public class AccountImpl implements Account {

    @Override
    public void queryAccount() {
        System.out.println("查看账户方法...");
    }

    @Override
    public void updateAccount() {
        System.out.println("修改账户方法...");
    }
}
