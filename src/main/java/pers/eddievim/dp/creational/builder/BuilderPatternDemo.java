package pers.eddievim.dp.creational.builder;

/**
 * @author eddie
 * @create 2021/4/10 14:20
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        Builder chinaBuilder = new ChinaHouseBuilderImpl();
        Builder japanBuilder = new JapanHouseBuilderImpl();

        chinaBuilder.buildAll();
        System.out.println("---");
        japanBuilder.buildAll();
    }
}

interface Builder {
    void buildAll();
}

interface HouseBuilder extends Builder {

    void buildFurniture();

    void buildDoor();

    void buildWindow();
}

class ChinaHouseBuilderImpl implements HouseBuilder {

    @Override
    public void buildAll() {
        this.buildDoor();
        this.buildWindow();
        this.buildFurniture();
    }

    @Override
    public void buildFurniture() {
        System.out.println("build furniture - Made in china.");
    }

    @Override
    public void buildDoor() {
        System.out.println("build door - Made in china.");
    }

    @Override
    public void buildWindow() {
        System.out.println("build window - Made in china.");
    }
}

class JapanHouseBuilderImpl implements HouseBuilder {

    @Override
    public void buildAll() {
        this.buildDoor();
        this.buildWindow();
        this.buildFurniture();
    }

    @Override
    public void buildFurniture() {
        System.out.println("build furniture - Made in japan.");
    }

    @Override
    public void buildDoor() {
        System.out.println("build door - Made in japan.");
    }

    @Override
    public void buildWindow() {
        System.out.println("build window - Made in japan.");
    }
}