package pers.eddievim.dp.action.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author eddieVim
 * @微信公众号 艾迪威姆 / PositiveEddie
 * @Blog https://blog.csdn.net/weixin_44129784
 * @Create 2021/1/16 09:41
 * @Discription
 */
public class MyLinkedList<T> implements MyCollection<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public MyLinkedList() {
        head = new Node<>(null, null);
        tail = head;
    }

    @Override
    public void add(T e) {
        size++;
        tail.setNext(new Node<>(e, tail));
        tail = tail.getNext();
    }

    @Override
    public T remove(T e) {
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (next == e) {
                iterator.remove();
                size--;
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
        return new MyLinkedIterator<>(head);
    }

    private static class MyLinkedIterator<T> implements Iterator<T> {

        private Node<T> cursor = null;

        public MyLinkedIterator(Node<T> head) {
            this.cursor = head;
        }

        @Override
        public boolean hasNext() {
            return this.cursor.getNext() != null;
        }

        @Override
        public T next() {
            this.cursor = this.cursor.getNext();
            return this.cursor.getVal();
        }

        @Override
        public void remove() {
            Node<T> prev = this.cursor.getPrev();
            Node<T> next = this.cursor.getNext();

            if (prev != null) {
                prev.setNext(next);
            }

            if (next != null) {
                next.setPrev(prev);
            }
        }
    }

    private static class Node<T> {

        private T val;
        private Node<T> next;
        private Node<T> prev;

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node(T val, Node<T> prev) {
            this.val = val;
            this.prev = prev;
        }

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        for (int i = 0; i < 10; i++) {
            myLinkedList.add(i);
        }

        myLinkedList.remove(9);

        Iterator<Integer> iterator1 = myLinkedList.iterator();

        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println("------------");

        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }

        linkedList.remove(9);

        Iterator<Integer> iterator2 = linkedList.iterator();

        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}
