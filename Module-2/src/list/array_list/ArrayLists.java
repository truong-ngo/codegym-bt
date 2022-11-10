package list.array_list;

public class ArrayLists<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public ArrayLists() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayLists(int capacity) {
        elements = new Object[capacity];
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        if (size == elements.length) {
            ensureCapacity(size + 1);
        }
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    public void ensureCapacity (int minCapacity) {
        if (elements.length < minCapacity) {
            Object[] newElements = new Object[minCapacity];
            System.arraycopy(elements,0,newElements,0,elements.length);
            elements = newElements;
        }
    }

    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        E removeElement = (E) elements[index];
        for (int i = index; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return removeElement;
    }

    public boolean contains(E element) {
        for (Object e : elements) {
            if (element.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public Object clone() {
        ArrayLists<E> newArrayList = new ArrayLists<E>(size);
        newArrayList.ensureCapacity(size);
        if (size >= 0) System.arraycopy(elements, 0, newArrayList.elements, 0, size);
        return newArrayList;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        return (E) elements[index];
    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapacity(size + 1);
        }
        elements[size++] = e;
        return true;
    }
}
