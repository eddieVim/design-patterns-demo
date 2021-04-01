package pers.eddievim.dp.action.iterator;

import java.util.Iterator;

/**
 * @Author eddieVim
 * @微信公众号 艾迪威姆 / PositiveEddie
 * @Blog https://blog.csdn.net/weixin_44129784
 * @Create 2021/1/16 09:39
 * @Discription
 */
public interface MyCollection<T> {

    void add(T e);

    T remove(T e);

    int size();

    Iterator<T> iterator();
}
