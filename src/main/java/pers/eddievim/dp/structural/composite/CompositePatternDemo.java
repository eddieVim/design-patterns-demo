package pers.eddievim.dp.structural.composite;

import java.util.Arrays;
import java.util.List;

/**
 * @author eddie
 * @create 2021/4/11 18:12
 */
public class CompositePatternDemo {
    public static void main(String[] args) {
        Menu menu1 = new Menu(new Info("name1", "detail"), (Menu) null);
        Menu menu2 = new Menu(new Info("name2", "detail"), (Menu) null);
        Menu menu3 = new Menu(new Info("name3", "detail"), menu1, menu2);
        Menu menu4 = new Menu(new Info("name4", "detail"), menu3);
        Menu menu5 = new Menu(new Info("name5", "detail"), menu4);

        System.out.println(menu5);
    }
}

class Menu {
    private Info info;
    private List<Menu> sonMenus;

    public Menu(Info info, Menu... sonMenus) {
        this.info = info;
        assert sonMenus != null;
        this.sonMenus = Arrays.asList(sonMenus);
    }

    @Override
    public String toString() {
        return "Menu{\n" +
                "\tinfo=" + info +
                ", \n\tsonMenus=\n\t\t" + sonMenus + '\n' +
                '}';
    }
}

class Info {
    private String name;
    private String detail;

    public Info(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
