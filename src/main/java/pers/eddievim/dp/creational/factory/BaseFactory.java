package pers.eddievim.dp.creational.factory;

/**
 * 所有工厂类的基本类
 *
 * @author eddieVim
 * @微信公众号 埃迪的Code日记 / PositiveEddie
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/23 8:58 下午
 */
public abstract class BaseFactory {

    /**
     * 工厂开工
     */
    public void begin() {
        System.out.println("---开工了---");
    }

    /**
     * 生产武器
     * @return 武器
     */
    public abstract BaseWeapon createWeapon();

    /**
     * 生产手机
     * @return 手机
     */
    public abstract BasePhone createPhone();

    /**
     * 工厂收工
     */
    public void end() {
        System.out.println("---收工了---");
    }
}
