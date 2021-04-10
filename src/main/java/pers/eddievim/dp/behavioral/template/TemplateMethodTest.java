package pers.eddievim.dp.behavioral.template;

/**
 * @author eddie
 * @create 2021/3/31 22:14
 */
public class TemplateMethodTest {
    public static void main(String[] args) {
        new Thread(new PutEvent()).start();
        new Thread(new RemoveEvent()).start();
    }
}

abstract class AbstractEvent implements Runnable {
    protected boolean processComplated;
    @Override
    public void run() {
        System.out.println("template method running..");
        // 未完成，重新执行
        while (processComplated) {
            doRun();
        }
    }

    protected abstract void doRun();
}

class PutEvent extends AbstractEvent {

    @Override
    protected void doRun() {
        System.out.println("put");
        processComplated = true;
    }
}

class RemoveEvent extends AbstractEvent {

    @Override
    protected void doRun() {
        System.out.println("remove");
        processComplated = true;
    }
}