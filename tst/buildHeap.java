import java.util.*;

class buildHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays
            .stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        Heap heap = new Heap(array.length);

        heap.buildHeap(array);
        System.out.println(heap.printHeap());
    }
}

class Heap {
    int[] heap;
    int tail;
    int capacity;

    public Heap(int capacity) {
        this.heap = new int[capacity];
        this.capacity = capacity;
        this.tail = -1;
    }

    public boolean isEmpty() {
        return this.tail == -1;
    }

    public boolean isFull() {
        return this.tail == this.capacity - 1;
    }

    public int left(int index) {
        return 2 * index + 1;
    }

    public int right(int index) {
        return 2 * (index + 1);
    }

    public int parent(int index) {
        return (int) (index - 1) / 2;
    }

    public void add(int n) {
        this.heap[++this.tail] = n;

        int i = this.tail;
        while (i > 0 && this.heap[i] > this.heap[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public void swap(int indA, int indB) {
        if (isValidIndex(indA) && isValidIndex(indB)) {
            int aux = this.heap[indA];
            this.heap[indA] = this.heap[indB];
            this.heap[indB] = aux;
        }
    }

    public boolean isValidIndex(int index) {
        return index >= 0 && index <= this.tail;
    }

    public int remove() {
       if (isEmpty()) throw new RuntimeException("heap is empty");

       int element = this.heap[0];
       swap(0, this.tail);

       heapify(0);

       return element;
    }

    public void heapify(int index) {
        if (isValidIndex(index) && !isLeaf(index)) {
            int max = max_index(index, left(index), right(index));
            if (max != index) {
                swap(max, index);
                heapify(max);
            }
        }
    }

    public boolean isLeaf(int index) {
        return index > parent(this.tail) && index <= this.tail;
    }

    public int max_index(int index, int left, int right) {
        int i;
        if (isValidIndex(left) && !isValidIndex(right)) {
            i = Math.max(this.heap[index], this.heap[left]);
            if (i == this.heap[index]) return index;
            else return left;
        } else if (isValidIndex(right) && !isValidIndex(left)) {
            i = Math.max(this.heap[index], this.heap[right]);
            if (i == this.heap[index]) return index;
            else return right;
        } else if (isLeaf(index)) {
            return index;
        } else {
            i = Math.max(this.heap[index], Math.max(this.heap[right], this.heap[left]));
            if (i == this.heap[index]) return index;
            else if (i == this.heap[left]) return left;
            else return right;
        }
    }

    public void buildHeap(int[] array) {
        this.heap = array;
        this.tail = array.length - 1;
        this.capacity = array.length;
        for (int i = parent(array.length - 1); i >= 0; i--)
            heapify(i);
    }

    public String printHeap() {
        return Arrays.toString(this.heap);
    }
}
