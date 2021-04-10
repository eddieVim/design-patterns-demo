package pers.eddievim.dp.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author eddieVim
 * @微信公众号 艾迪威姆 / PositiveEddie
 * @Blog https://blog.csdn.net/weixin_44129784
 * @Create 2021/1/15 23:20
 * @Discription
 */
public class MyArrayList <T> implements MyCollection<T> {
    private T[] arr;
    private int size = 0;
    private int capacity = 10;

    public MyArrayList() {
        arr = (T[]) new Object[capacity];
    }

    public MyArrayList(int n) {
        this.capacity = n;
        arr = (T[]) new Object[capacity];
    }

    @Override
    public void add(T e) {
        arr[size++] = e;
    }

    @Override
    public T remove(T e) {
        for (int i = 0; i < size; i++) {
            if (e == arr[i]) {
                for (int j = i + 1; j < size; j++) {
                    arr[j - 1] = arr[j];
                }
                this.size--;
                return e;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayIterator();
    }

    private class MyArrayIterator implements Iterator<T> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            if (cursor >= arr.length || arr[cursor] == null) {
                return false;
            }
            return true;
        }

        @Override
        public T next() {
            if (arr[cursor] == null) {
                throw new RuntimeException("worried!!!");
            }
            return arr[cursor++];
        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }

        Iterator<Integer> iterator1 = list1.iterator();

        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println("-----------------");

        MyArrayList<Integer> list2 = new MyArrayList<>();

        for (int i = 0; i < 10; i++) {
            list2.add(i);
        }
        
        Iterator<Integer> iterator2 = list2.iterator();

        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}
