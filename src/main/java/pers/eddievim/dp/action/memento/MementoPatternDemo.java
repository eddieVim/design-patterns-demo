package pers.eddievim.dp.action.memento;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author eddie
 * @create 2021/4/10 11:03
 */
public class MementoPatternDemo {
    public static void main(String[] args) {

        QuarterStack quarterStack = new QuarterStack();

        Quarter s1 = new Quarter("S1");
        quarterStack.snapShoot(s1);
        System.out.println(s1);

        Quarter s2 = new Quarter("S2");
        quarterStack.snapShoot(s2);
        System.out.println(s2);

        Quarter s3 = new Quarter("S3");
        quarterStack.snapShoot(s3);
        System.out.println(s3);

        System.out.println("回溯---");

        System.out.println(quarterStack.recall());
        System.out.println(quarterStack.recall());
        System.out.println(quarterStack.recall());
    }
}

class Quarter {
    private String state;

    public Quarter(String state) {
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    @Override
    public Quarter clone() {
        Quarter quarter = new Quarter(state);
        return quarter;
    }

    @Override
    public String toString() {
        return "当前季度：" + state;
    }
}

class QuarterStack {
    private Deque<Quarter> stack;

    public QuarterStack() {
        stack = new LinkedList<>();
    }

    public void snapShoot(Quarter quarter) {
        stack.push(quarter);
    }

    public Quarter recall() {
        return stack.poll();
    }
}