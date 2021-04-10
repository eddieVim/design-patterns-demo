package pers.eddievim.dp.structural.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author eddie
 * @create 2021/4/10 14:30
 */
public class DynamicProxyPatternDemo {
    public static void main(String[] args) {
        Subject subject = new TestSubject();

        InvocationHandler handler = new MyInvocationHandler(subject);

        Subject o = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), TestSubject.class.getInterfaces(), handler);

        o.doSomething();
    }
}

interface Subject {
    void doSomething();
}

class TestSubject implements Subject {

    @Override
    public void doSomething() {
        System.out.println("do something..");
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object object;

    public MyInvocationHandler(Object o) {
        object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before.");
        Object invoke = method.invoke(object, args);
        System.out.println("after.");
        return invoke;
    }
}
