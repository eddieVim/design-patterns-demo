package pers.eddievim.dp.creational.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 完美式懒汉式单例
 * 用的时候才初始化，节省了内存，完美解决了多线程问题
 * 双重检查，并用volatile保证原子性
 *
 * @author eddievim
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/18 10:40 上午
 */
public class LazyOK {
    private volatile static LazyOK INSTANCE;

    private LazyOK() {}

    public static LazyOK getInstance() {
        if (INSTANCE == null) {
            synchronized (LazyOK.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyOK();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(10 * 1000);
        long start = System.currentTimeMillis();


        for (int i = 0; i < 10 * 1000; i++) {
            new Thread(()->{
                System.out.println(System.identityHashCode(LazyOK.getInstance()));
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        System.out.println(System.currentTimeMillis() - start);
    }
}
