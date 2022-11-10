package design_pattern.bullet;

import java.util.LinkedList;

public abstract class MemoryPool<T> {
    private LinkedList<T> freeItems = new LinkedList<>();

    public void freeItem(T item) {
        freeItems.add(item);
    }

    protected abstract T allocate();

    public T newItem() {
        T out = null;
        if (freeItems.size() == 0) {
            out = allocate();
        } else {
            out = freeItems.getFirst();
            freeItems.removeFirst();
        }
        return out;
    }
}
