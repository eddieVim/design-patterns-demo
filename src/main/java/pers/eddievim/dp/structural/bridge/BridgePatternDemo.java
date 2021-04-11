package pers.eddievim.dp.structural.bridge;

/**
 * @author eddie
 * @create 2021/4/11 16:38
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Bridge bridge = new BridgeImpl(new ConcreteImpl());
        bridge.run();
    }
}

abstract class Bridge {
    protected Impl impl;

    public Bridge(Impl impl) {
        this.impl = impl;
    }

    abstract void run();
}

class BridgeImpl extends Bridge {

    public BridgeImpl(Impl impl) {
        super(impl);
    }

    @Override
    void run() {
        System.out.println("BridgeImpl method run.");
        impl.run();
        System.out.println("BridgeImpl method over.");
    }
}

interface Impl {
    void run();
}

class ConcreteImpl implements Impl {

    @Override
    public void run() {
        System.out.println("run..");
    }
}