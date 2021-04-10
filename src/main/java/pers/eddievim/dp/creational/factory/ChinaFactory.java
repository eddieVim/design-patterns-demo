package pers.eddievim.dp.creational.factory;

/**
 * 中国工厂
 *
 * @author eddieVim
 * @微信公众号 埃迪的Code日记 / PositiveEddie
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/23 9:11 下午
 */
public class ChinaFactory extends BaseFactory {

    @Override
    public BaseWeapon createWeapon() {
        return new QBZ95();
    }

    @Override
    public BasePhone createPhone() {
        return new HuaWei();
    }
}
