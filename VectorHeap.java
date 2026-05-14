import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    protected Vector<E> data;

    public VectorHeap() {
        data = new Vector<E>();
    }

    protected static int parent(int i) { return (i - 1) / 2; }
    protected static int left(int i) { return 2 * i + 1; }
    protected static int right(int i) { return 2 * i + 2; }

    public boolean isEmpty() { return data.size() == 0; }
    public int size() { return data.size(); }
    public void clear() { data.clear(); }
    public E getFirst() { return data.get(0); }
    
    public void add(E value) {}
    public E remove() { return null; }
}