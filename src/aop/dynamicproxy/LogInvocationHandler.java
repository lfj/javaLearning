package aop.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 该方法是基于jdk实现的动态代理
 */
interface Hello {
    String sayHello(String str);
}

class HelloImp implements Hello {
    @Override
    public String sayHello(String str) {
        return "HelloImp: " + str;
    }
}

public class LogInvocationHandler implements InvocationHandler {
    private Hello hello;

    public LogInvocationHandler(Hello hello) {
        this.hello = hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("sayHello".equals(method.getName())) {
            System.out.println("You said: " + Arrays.toString(args));
        }
        return method.invoke(hello, args);
    }

    public static void main(String[] args) {
        Hello hello = (Hello) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(), // 1. 类加载器
                new Class<?>[]{Hello.class}, // 2. 代理需要实现的接口，可以有多个
                new LogInvocationHandler(new HelloImp()));// 3. 方法调用的实际处理者
        System.out.println(hello.sayHello("I love you!"));
    }
}