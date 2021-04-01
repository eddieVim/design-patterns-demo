package pers.eddievim.dp.create.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 懒汉式单例，静态内部类的形式，完美的单例
 *
 * @author eddievim
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/18 11:24 上午
 */
public class LazyInner {

    private LazyInner() {}

    private static class Inner {
        private static final LazyInner INSTANCE = new LazyInner();
    }

    public static LazyInner getInstance() {
        return Inner.INSTANCE;
    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(10 * 1000);
        long start = System.currentTimeMillis();


        for (int i = 0; i < 10 * 1000; i++) {
            new Thread(()->{
                System.out.println(System.identityHashCode(LazyInner.getInstance()));
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        System.out.println(System.currentTimeMillis() - start);
    }
}
