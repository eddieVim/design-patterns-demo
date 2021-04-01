package pers.eddievim.dp.action.strategy;

/**
 * 需要实现的策略
 *
 * @author eddievim
 * @微信公众号 埃迪的Code日记 / PositiveEddie
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/21 5:04 下午
 */
public interface MyComparator<T> {
    /**
     * 根据返回值的正负来判断，o1对象与o2对象应该怎么排序
     * 负数的情况： o1, o2
     * 正数的情况： o2, o1
     *
     * @param o1 第一个参数
     * @param o2 第二个参数
     * @return 返回值
     */
    public int compare(T o1, T o2);
}
