package aop.dynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 该类是使用CGLIB实现的动态代理
 */
class HelloConcrete {
    public String sayHello(String str) {
        return "HelloConcrete: " + str;
    }
}

public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("You said: " + Arrays.toString(args));
        return proxy.invokeSuper(obj, args);
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloConcrete.class);
        enhancer.setCallback(new MyMethodInterceptor());

        HelloConcrete hello = (HelloConcrete) enhancer.create();
        System.out.println(hello.sayHello("I love you!"));
    }
}
