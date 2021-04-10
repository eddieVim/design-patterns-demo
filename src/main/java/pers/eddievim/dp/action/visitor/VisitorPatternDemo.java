package pers.eddievim.dp.action.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eddie
 * @create 2021/4/10 10:30
 */
public class VisitorPatternDemo {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.add(new MemoryCache());
        objectStructure.add(new DiskCache());


        LocalVisitor localVisitor = new LocalVisitor();
        RemoteVisitor remoteVisitor = new RemoteVisitor();

        objectStructure.accept(localVisitor);
        objectStructure.accept(remoteVisitor);
    }
}

interface Visitor {
    void visitMemory(MemoryCache memoryCache);
    void visitDisk(DiskCache diskCache);
}

interface Cache {
    /**
     * 接收访问者访问
     * @param visitor 访问者
     */
    void accept(Visitor visitor);
}

class MemoryCache implements Cache {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMemory(this);
    }

    public String getDataFromMemory() {
        return "data from memory.";
    }
}

class DiskCache implements Cache {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDisk(this);
    }

    public String getDataFromDisk() {
        return "data from disk.";
    }
}

class LocalVisitor implements Visitor {

    @Override
    public void visitMemory(MemoryCache memoryCache) {
        System.out.println("local visitor:" + memoryCache.getDataFromMemory());
    }

    @Override
    public void visitDisk(DiskCache diskCache) {
        System.out.println("local visitor:" + diskCache.getDataFromDisk());
    }
}

class RemoteVisitor implements Visitor {

    @Override
    public void visitMemory(MemoryCache memoryCache) {
        System.out.println("remote visitor: " + memoryCache.getDataFromMemory());
    }

    @Override
    public void visitDisk(DiskCache diskCache) {
        System.out.println("remote visitor: " + diskCache.getDataFromDisk());
    }
}

class ObjectStructure implements Cache {
    private List<Cache> list = new ArrayList<>();

    public void add(Cache cache) {
        list.add(cache);
    }

    public boolean remove(Cache cache) {
        return list.remove(cache);
    }

    @Override
    public void accept(Visitor visitor) {
        for (Cache cache : list) {
            cache.accept(visitor);
        }
    }
}