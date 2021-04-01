package pers.eddievim.dp.create.factory;

/**
 * @author eddieVim
 * @微信公众号 埃迪的Code日记 / PositiveEddie
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/23 12:58 下午
 */
public interface Produce {
    public void function();
}

class ProduceA implements Produce {

    @Override
    public void function() {
        System.out.println("A");
    }

}

class ProduceB implements Produce {

    @Override
    public void function() {
        System.out.println("B");
    }

}
