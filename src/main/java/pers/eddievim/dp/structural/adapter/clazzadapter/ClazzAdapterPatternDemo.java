package pers.eddievim.dp.structural.adapter.clazzadapter;

/**
 * @author eddie
 * @create 2021/4/10 15:32
 */
public class ClazzAdapterPatternDemo {
    public static void main(String[] args) {
        MyExecutor myExecutor = new MyExecutor();
        myExecutor.execute(new ClazzAdapter());
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

class ClazzAdapter extends MyClazz implements MyRunnable {

    @Override
    public void run() {
        sayHi();
    }
}