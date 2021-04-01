package pers.eddievim.dp.create.factory;

/**
 * 美国工厂
 *
 * @author eddieVim
 * @微信公众号 埃迪的Code日记 / PositiveEddie
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/23 9:12 下午
 */
public class USAFactory extends BaseFactory {
    @Override
    public BaseWeapon createWeapon() {
        return new M4A1();
    }

    @Override
    public BasePhone createPhone() {
        return new IPhone();
    }
}
