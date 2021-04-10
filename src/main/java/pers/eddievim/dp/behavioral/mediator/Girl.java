package pers.eddievim.dp.behavioral.mediator;

/**
 * @author eddieVim
 * @微信公众号 埃迪的Code日记 / PositiveEddie
 * @blog https://blog.csdn.net/weixin_44129784
 * @create 2020/8/26 3:37 下午
 */
public interface Girl {
    public void sayHi();
}

class CommonGirl implements Girl {

    String name;
    double height;
    double weight;

    @Override
    public void sayHi() {
        System.out.println("hi");
    }

    @Override
    public String toString() {
        return "CommonGirl{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}

class BeautifulGirl implements Girl {

    String name;
    double height;
    double weight;

    public BeautifulGirl(CommonGirl girl) {
        // 增高5cm
        girl.height += 5;
        // 减重10斤
        girl.weight -= 10;
        // 变美
        this.name = girl.name;
        this.height = girl.height;
        this.weight = girl.weight;
    }

    @Override
    public String toString() {
        return "BeautifulGirl{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public void sayHi() {
        System.out.println("hi");
    }
}

class GirlFriend implements Girl {
    Girl girl;
    String boyFirendName = "Eddie";

    public GirlFriend(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "girl=" + girl +
                ", boyFirendName='" + boyFirendName + '\'' +
                '}';
    }

    @Override
    public void sayHi() {
        girl.sayHi();
    }
}

class Main {
    public static void main(String[] args) {
        // 一个普通的女孩
        CommonGirl commonGirl = new CommonGirl();
        commonGirl.height = 160;
        commonGirl.weight = 105;
        commonGirl.name = "Ruby";
        commonGirl.sayHi();
        System.out.println(commonGirl);

        // 蜕变成漂亮的女孩
        BeautifulGirl beautifulGirl = new BeautifulGirl(commonGirl);
        beautifulGirl.sayHi();
        System.out.println(beautifulGirl);

        // 变成女朋友了
        GirlFriend girlFriend = new GirlFriend(beautifulGirl);
        girlFriend.sayHi();
        System.out.println(girlFriend);
    }
}
