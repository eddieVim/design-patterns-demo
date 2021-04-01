package pers.eddievim.dp.struct.wrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eddie
 * @create 2021/3/31 11:36
 */
abstract class Component {
    public abstract void show();
}

class MyNewHouse extends Component {

    @Override
    public void show() {
        System.out.println("this is eddie's home.");
    }
}

class Furniture extends Component {

    @Override
    public void show() {
        System.out.print("Furniture in my house: ");
    }
}

class TV extends Furniture {

    @Override
    public void show() {
        super.show();
        System.out.println("TV.");
    }
}

class Sofa extends Furniture {
    @Override
    public void show() {
        super.show();
        System.out.println("Sofa.");
    }
}

class MyNewHouseWrapper extends Component {
    private MyNewHouse myNewHouse;
    private List<Furniture> list;

    public MyNewHouseWrapper(MyNewHouse myNewHouse) {
        this.myNewHouse = myNewHouse;
        this.list = new ArrayList<>();
    }

    public boolean delFurniture(Furniture furniture) {
        return list.remove(furniture);
    }

    public void addFurniture(Furniture furniture) {
        this.list.add(furniture);
    }


    @Override
    public void show() {
        myNewHouse.show();
        for (Furniture furniture : list) {
            furniture.show();
        }
    }
}

/**
 * @author eddie
 */
public class WrapperTestApp {
    public static void main(String[] args) {
        MyNewHouse myNewHouse = new MyNewHouse();

        MyNewHouseWrapper myNewHouseWrapper = new MyNewHouseWrapper(myNewHouse);
        myNewHouseWrapper.show();

        Furniture tv = new TV();
        Furniture sofa = new Sofa();

        System.out.println("----------");

        myNewHouseWrapper.addFurniture(tv);
        myNewHouseWrapper.addFurniture(sofa);
        myNewHouseWrapper.show();
    }
}