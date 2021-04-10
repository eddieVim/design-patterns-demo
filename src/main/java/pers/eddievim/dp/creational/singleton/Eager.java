package pers.eddievim.dp.creational.singleton;

/**
 * 饿汉式单例
 * 类一加载就初始化
 * 优点：简单实用；多数情况，可这样写
 * 缺点：不管是否用到，只要类被加载就初始化了，占用内存
 *
 * @author eddievim
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/18 10:34 上午
 */
public class Eager {
    /**
     * static变量在类加载的时候就已经初始化了
     */
    private static final Eager INSTANCE = new Eager();

    /**
     * 权限设置为private，防止外部重新new一个对象
     */
    private Eager() {}

    /**
     * 获取单例对象的接口
     * @return 返回单例对象
     */
    public static Eager getInstance() {
        return INSTANCE;
    }
}
