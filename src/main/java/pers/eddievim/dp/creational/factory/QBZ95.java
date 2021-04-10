package pers.eddievim.dp.creational.factory;

/**
 * QBZ95 武器类
 *
 * @author eddieVim
 * @微信公众号 埃迪的Code日记 / PositiveEddie
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/23 9:03 下午
 */
public class QBZ95 extends BaseWeapon {
    @Override
    public void shoot() {
        System.out.println("tututu...tututu...");
    }

    @Override
    public void introduce() {
        System.out.println("I'm QBZ95.");
    }
}
