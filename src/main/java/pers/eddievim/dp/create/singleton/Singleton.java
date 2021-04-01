package pers.eddievim.dp.create.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 枚举类单例
 * 解决了多线程问题
 * 还可以防止反序列化，防止通过class文件通过反射机制new一个对象，原因（enum没有构造方法）
 *
 * @author eddievim
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/18 2:38 下午
 */
public enum Singleton {

    INSTANCE;

    public String hello() {return "hello, world!";}

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(10 * 1000);
        long start = System.currentTimeMillis();


        for (int i = 0; i < 10 * 1000; i++) {
            new Thread(()->{
                // System.out.println(Singleton.INSTANCE.hello());
                // System.out.println(System.identityHashCode(Singleton.INSTANCE.hello()));
                System.out.println(System.identityHashCode(Singleton.INSTANCE));
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        System.out.println(System.currentTimeMillis() - start);
    }
}
