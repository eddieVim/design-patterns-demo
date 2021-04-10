package pers.eddievim.dp.behavioral.state;

/**
 * @author eddie
 * @create 2021/4/8 15:01
 */
public class StatePatternTest {
    public static void main(String[] args) {
        Context context = new Context();
        System.out.println(context);

        for (int i = 0; i < 3; i++) {
            context.flip();
            System.out.println(context);
        }
    }
}

class Context {
    private State state;
    private boolean switchA;
    private boolean switchB;
    private boolean switchC;

    @Override
    public String toString() {
        return "Context{" +
                "state=" + state +
                ", switchA=" + switchA +
                ", switchB=" + switchB +
                ", switchC=" + switchC +
                '}';
    }

    public Context() {
        state = Closed.getInstance();
    }

    public void flip() {
        state.flip(this);
    }

    public void setSwitch(boolean bool) {
        this.switchA = bool;
        this.switchB = bool;
        this.switchC = bool;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

interface State {
    void flip(Context context);

    interface Singleton {
    }
}

class Running implements State {

    @Override
    public void flip(Context context) {
        context.setState(Closed.getInstance());
        context.setSwitch(false);
    }

    private static class Singleton implements State.Singleton {
        public static State STATE = new Running();
    }

    public static State getInstance() {
        return Singleton.STATE;
    }
}

class Closed implements State {

    @Override
    public void flip(Context context) {
        context.setState(Running.getInstance());
        context.setSwitch(true);
    }

    private static class Singleton implements State.Singleton {
        public static State STATE = new Closed();
    }

    public static State getInstance() {
        return Singleton.STATE;
    }
}
