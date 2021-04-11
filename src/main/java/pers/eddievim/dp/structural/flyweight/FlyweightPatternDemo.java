package pers.eddievim.dp.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eddie
 * @create 2021/4/11 17:46
 */
public class FlyweightPatternDemo {
    public static void main(String[] args) {

    }
}

interface Flyweight {
    void run();
}

class ConcreteFlyweight implements Flyweight {

    @Override
    public void run() {
        System.out.println("flyweight run.");
    }
}

class FlyweightFactory {
    private Map<String, Flyweight> map = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        return map.containsKey(key) ? map.get(key) : map.put(key, new ConcreteFlyweight());
    }
}
