package pers.eddievim.dp.structural.adapter.objectadapter;

/**
 * @author eddie
 * @create 2021/4/10 15:41
 */
public class ObjectAdapterPatternDemo {
    public static void main(String[] args) {
        MyExecutor myExecutor = new MyExecutor();
        myExecutor.execute(new MyClazzAdapter(new MyClazz()));
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

class MyClazz {
    void sayHi() {
        System.out.println("Hi.");
    }
}

class MyClazzAdapter implements MyRunnable {
    private MyClazz myClazz;

    public MyClazzAdapter(MyClazz myClazz) {
        this.myClazz = myClazz;
    }

    @Override
    public void run() {
        myClazz.sayHi();
    }
}