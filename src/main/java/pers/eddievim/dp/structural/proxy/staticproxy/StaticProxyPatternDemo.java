package pers.eddievim.dp.structural.proxy.staticproxy;

/**
 * @author eddie
 * @create 2021/4/10 14:28
 */
public class StaticProxyPatternDemo {
    public static void main(String[] args) {
        Subject testSubject = new TestSubject();

        Subject testProxy = new TestProxyImpl(testSubject);

        testProxy.doSomething();
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

interface Proxy {
    void beforeDo();
    void afterDo();
}

class TestProxyImpl implements Proxy, Subject {

    Subject subject;

    public TestProxyImpl(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void beforeDo() {
        System.out.println("proxy before do..");
    }



    @Override
    public void afterDo() {
        System.out.println("proxy after do..");
    }

    @Override
    public void doSomething() {
        beforeDo();
        subject.doSomething();
        afterDo();
    }
}
