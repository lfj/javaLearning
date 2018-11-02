package designpattern.proxydesign;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 该类是使用jdk的代理实现的动态代理
 */
public class AccountProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        /* 要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)   */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("事务开始");
        result = method.invoke(target, args);
        System.out.println("事务结束");
        return result;
    }

    public static void main(String[] args) {
        AccountProxy proxy = new AccountProxy();
        Account accountProxy = (Account) proxy.bind(new AccountImpl());
        accountProxy.updateAccount();
    }
}
