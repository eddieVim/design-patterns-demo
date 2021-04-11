package pers.eddievim.dp.structural.adapter.objectadapter;

/**
 * @author eddie
 * @create 2021/4/10 15:41
 */
public class ObjectAdapterPatternDemo {
    public static void main(String[] args) {
        MyExecutor myExecutor = new MyExecutor();
        myExecutor.execute(new Adapter(new Adaptee()));
    }
}

class MyExecutor {
    void execute(MyRunnable runnable) {
        runnable.run();
    }
}

interface MyRunnable {
    void run();
}

class Adaptee {
    void sayHi() {
        System.out.println("Hi.");
    }
}

class Adapter implements MyRunnable {
    private Adaptee Adaptee;

    public Adapter(Adaptee Adaptee) {
        this.Adaptee = Adaptee;
    }

    @Override
    public void run() {
        Adaptee.sayHi();
    }
}