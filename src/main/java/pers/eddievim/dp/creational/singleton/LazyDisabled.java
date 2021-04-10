package pers.eddievim.dp.creational.singleton;

/**
 * 有缺陷的懒汉式单例
 * 用的时候才初始化，节省了内存，但有线程安全问题
 *
 * @author eddievim
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/18 10:54 上午
 */
public class LazyDisabled {
    private static LazyDisabled INSTANCE;

    private LazyDisabled() {}

    public static LazyDisabled getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        return new LazyDisabled();
    }

    public static void main(String[] args) {
        // 并发地去获取对象
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(System.identityHashCode(LazyDisabled.getInstance()));
            }).start();
        }
    }
}
