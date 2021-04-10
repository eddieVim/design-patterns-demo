package pers.eddievim.dp.creational.factory;

/**
 * @author eddieVim
 * @微信公众号 埃迪的Code日记 / PositiveEddie
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/23 10:05 下午
 */
public class Main {
    public static void main(String[] args) {
        BaseFactory factory = new ChinaFactory();
        // BaseFactory factory = new USAFactory();
        // 工厂开始工作
        factory.begin();

        BaseWeapon weapon = factory.createWeapon();
        weapon.introduce();
        weapon.shoot();

        BasePhone phone = factory.createPhone();
        phone.introduce();
        phone.welcome();

        // 工厂停止工作
        factory.end();
    }
}
