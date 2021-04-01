package pers.eddievim.dp.action.command;

import java.util.LinkedList;
import java.util.List;

/**
 * @author eddie
 * @create 2021/4/1 10:41
 */
public class CommandTestApp {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        Receiver<String> receiver = new ListReceiver<>(linkedList);
        receiver.receiveAndHandle(new Event<>(Command.ADD, "Hello, world!"));
        receiver.receiveAndHandle(new Event<>(Command.ADD, "OK"));
        receiver.receiveAndHandle(new Event<>(Command.REMOVE, "Hello, world!"));
    }
}

interface Receiver<T> {
    /**
     * 接收并进行处理
     *
     * @param event 事件
     */
    void receiveAndHandle(Event<T> event);
}

class Event<T> {
    public Command command = null;
    public T value;

    public Event(Command command, T value) {
        this.command = command;
        this.value = value;
    }
}

class ListReceiver<T> implements Receiver<T> {

    private List<T> innerList;

    public ListReceiver(List<T> innerList) {
        this.innerList = innerList;
    }

    @Override
    public void receiveAndHandle(Event<T> event) {
        switch (event.command) {
            case ADD:
                innerList.add(event.value);
                System.out.println("Command ADD process.");
                printInnerList();
                break;
            case REMOVE:
                innerList.remove(event.value);
                System.out.println("Command REMOVE process.");
                printInnerList();
                break;
            default:
                break;
        }
    }

    private void printInnerList() {
        if (innerList.isEmpty()) {
            System.out.println("Inner list is empty.");
            return;
        }
        System.out.println("\tInner list print:");
        int i = 0;
        for (T s : innerList) {
            System.out.print("\t"+ (++i) + ". " + s);
        }
        System.out.println();
    }
}

enum Command {
    // add command
    ADD,
    // remove command
    REMOVE
}
