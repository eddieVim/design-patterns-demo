package pers.eddievim.dp.structural.facade;

/**
 * @author eddie
 * @create 2021/4/11 17:41
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        Facade facade = new Facade(new SubSystemA(), new SubSystemB(), new SubSystemC());

        facade.run();
    }
}

class Facade {
    private SubSystem subSystemA;
    private SubSystem subSystemB;
    private SubSystem subSystemC;

    public Facade(SubSystem subSystemA, SubSystem subSystemB, SubSystem subSystemC) {
        this.subSystemA = subSystemA;
        this.subSystemB = subSystemB;
        this.subSystemC = subSystemC;
    }

    public void run() {
        subSystemA.run();
        subSystemB.run();
        subSystemC.run();
    }
}

interface SubSystem {
    void run();
}

class SubSystemA implements SubSystem {
    @Override
    public void run() {
        System.out.println("A run.");
    }
}

class SubSystemB implements SubSystem {
    @Override
    public void run() {
        System.out.println("B run.");
    }
}

class SubSystemC implements SubSystem {
    @Override
    public void run() {
        System.out.println("C run.");
    }
}