package pers.eddievim.dp.action.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Subject {
    private List<Watcher> watchers = new ArrayList<>();

    public Subject() {
        Runtime.getRuntime().addShutdownHook(new ShutDownHookThread());
    }

    public void publish(Event event, Watcher watcher) {
        watcher.process(event);
    }

    public void publish(Event event) {
        for (Watcher watcher : watchers) {
            watcher.process(event);
        }
    }

    private void addWatcher(Watcher watcher) {
        watchers.add(watcher);
    }

    private void removeWatcher(Watcher watcher) {
        watchers.remove(watcher);
    }

    /**
     * 关闭每个Watcher的线程
     */
    public void dispose() {
        for (Watcher watcher : watchers) {
            watcher.dispose();
        }
    }

    /**
     * 钩子线程，用于关闭线程池
     */
    public class ShutDownHookThread extends Thread {
        @Override
        public void run() {
            dispose();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Subject subject = new Subject();

        // 添加监听器
        subject.addWatcher(new Watcher());

        // 发布事件
        subject.publish(new Event() {
            @Override
            public void doRun() {
                System.out.println("eddie");
            }
        });

        // 请求推出系统
        System.exit(0);
    }
}

abstract class Event implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        doRun();
    }

    public abstract void doRun();
}



class Watcher {
    private ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

    public void process(Event event) {
        executor.execute(event);
    }

    public void dispose() {
        if (!this.executor.isShutdown()) {
            this.executor.shutdown();
        }
    }
}
