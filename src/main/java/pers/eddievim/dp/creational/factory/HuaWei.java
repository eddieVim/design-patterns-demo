package pers.eddievim.dp.creational.factory;

/**
 * @author eddieVim
 * @微信公众号 埃迪的Code日记 / PositiveEddie
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/23 10:04 下午
 */
public class HuaWei extends BasePhone {
    @Override
    public void welcome() {
        System.out.println("huawei");
    }

    @Override
    public void introduce() {
        System.out.println("I'm HuaWei Phone.");
    }
}
