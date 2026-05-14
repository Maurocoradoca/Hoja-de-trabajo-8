import java.util.Vector;

/**
 * Implementacion de una cola de prioridad usando un arbol binario 
 * guardado dentro de un Vector
 * * @param <E> El tipo de dato que guardaremos, tiene que implementar Comparable para poder ordenarlo
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    
    /**
     * El vector donde guardamos los datos del heap
     */
    protected Vector<E> data;

    /**
     * Constructor vacio que inicializa nuestro vector
     */
    public VectorHeap() {
        data = new Vector<E>();
    }

    /**
     * Calcula el indice del padre de un nodo
     * @param i El indice del nodo actual
     * @return El indice del nodo padre
     */
    protected static int parent(int i) { return (i - 1) / 2; }

    /**
     * Calcula el indice del hijo izquierdo
     * @param i El indice del nodo actual
     * @return El indice del hijo izquierdo
     */
    protected static int left(int i) { return 2 * i + 1; }

    /**
     * Calcula el indice del hijo derecho
     * @param i El indice del nodo actual
     * @return El indice del hijo derecho
     */
    protected static int right(int i) { return 2 * i + 2; }

    /**
     * Revisa si la cola esta vacia
     * @return true si no hay elementos, false si hay al menos uno
     */
    public boolean isEmpty() { return data.size() == 0; }

    /**
     * Nos dice cuantos elementos hay en la cola
     * @return La cantidad de elementos guardados
     */
    public int size() { return data.size(); }

    /**
     * Vacia por completo la cola de prioridad
     */
    public void clear() { data.clear(); }

    /**
     * Nos da el elemento con mayor prioridad (la raiz) sin sacarlo de la cola
     * @return El primer elemento del heap
     */
    public E getFirst() { return data.get(0); }
    
    /**
     * Agrega un nuevo valor al heap y lo acomoda en su posicion correcta
     * segun su prioridad
     * @param value El elemento que queremos meter a la cola
     */
    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Mueve un nodo hacia arriba en el arbol hasta que encuentre su lugar correcto
     * Esto mantiene el orden correcto del heap
     * @param leaf El indice del nodo que acabamos de insertar en la ultima posicion
     */
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }
    
    /**
     * Saca de la cola el elemento con mayor prioridad
     * @return El elemento que sacamos
     */
    @Override
    public E remove() {
        E minVal = getFirst();
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) {
            pushDownRoot(0);
        }
        return minVal;
    }

    /**
     * Agarra la nueva raiz  y la va empujando
     * hacia abajo comparandola con sus hijos para volver a arreglar el heap
     * @param root El indice desde donde empezamos a empujar hacia abajo 
     */
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) && ((data.get(childpos + 1)).compareTo(data.get(childpos)) < 0)) {
                    childpos++;
                }
                if ((data.get(childpos)).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }
}