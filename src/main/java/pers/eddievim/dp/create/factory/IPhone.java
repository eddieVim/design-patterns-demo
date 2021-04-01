package pers.eddievim.dp.create.factory;

/**
 * @author eddieVim
 * @微信公众号 埃迪的Code日记 / PositiveEddie
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/23 10:01 下午
 */
public class IPhone extends BasePhone {
    @Override
    public void welcome() {
        System.out.println("apple");
    }

    @Override
    public void introduce() {
        System.out.println("I'm iPhone");
    }
}
