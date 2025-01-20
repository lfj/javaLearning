package designpattern.proxydesign;

import io.lettuce.core.dynamic.intercept.MethodInterceptor;
import io.lettuce.core.dynamic.intercept.MethodInvocation;

/**
 * 使用cglib实现动态代理
 */
public class CountCglibProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object object) {
        return null;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        return null;
    }
}
