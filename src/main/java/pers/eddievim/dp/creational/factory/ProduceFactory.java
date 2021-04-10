package pers.eddievim.dp.creational.factory;

/**
 * @author eddieVim
 * @微信公众号 埃迪的Code日记 / PositiveEddie
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/23 12:58 下午
 */
public class ProduceFactory {

    public static void main(String[] args) {
        Produce produceA = new ProduceFactory().createA();
        produceA.function();

        Produce produceB = new ProduceFactory().createA();
        produceB.function();
    }

    public Produce createA() {
        return new ProduceA();
    }

    public Produce createB() {
        return new ProduceA();
    }
}
