package pers.eddievim.dp.creational.prototype;

/**
 * @author eddie
 * @create 2021/4/10 14:02
 */
public class PrototypePatternDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        Object clone = prototype.clone();

        System.out.println(prototype.hashCode() == clone.hashCode());

        System.out.println(prototype.equals(clone));

        System.out.println(prototype == prototype.clone());
    }
}

class Prototype implements Cloneable {
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}