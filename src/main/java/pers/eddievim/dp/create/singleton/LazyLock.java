package pers.eddievim.dp.create.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 有缺陷的懒汉式单例
 * 既然最普通的单例有并发问题，那么就加锁来解决
 * 缺点：效率低，每次去获取新的对象都要去竞争锁
 *
 * @author eddievim
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/18 11:03 上午
 */
public class LazyLock {
    private static LazyLock INSTANCE;

    private LazyLock() {}

    public synchronized static LazyLock getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazyLock();
        }
        return INSTANCE;
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(10 * 1000);
        long start = System.currentTimeMillis();


        for (int i = 0; i < 10 * 1000; i++) {
            new Thread(()->{
                System.out.println(System.identityHashCode(LazyLock.getInstance()));
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        System.out.println(System.currentTimeMillis() - start);
    }
}
