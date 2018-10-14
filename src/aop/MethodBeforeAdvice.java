package aop;

import java.lang.reflect.Method;

public class MethodBeforeAdvice implements org.springframework.aop.MethodBeforeAdvice {
    public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
        System.out.println("==Before==");
    }
}
