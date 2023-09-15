import java.util.*;

class trimLinkedList {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] array = Arrays
        .stream(sc.nextLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    int qntExtremos = Integer.parseInt(sc.nextLine());
    LinkedList list = new LinkedList(array.length);

    for (int i = 0; i < array.length; i++)
        list.addLast(array[i]);

    for (int j = 0; j < qntExtremos; j++) {
        list.removeFirst();
        list.removeLast();
    }

    if (list.isEmpty()) {
        System.out.println("vazia");
    } else {
        for (int k = 0; k < list.getSize(); k++) {
            if (k == list.getSize() - 1)
                System.out.println(list.get(k));
            else
                System.out.print(list.get(k) + " ");
        }
    }
  }
}

class Node {
    Node next;
    Node prev;
    int v;

    Node(int n) {
        this.next = null;
        this.prev = null;
        this.v = n;
    }
}

class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList(int size) {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addLast(int n) {
        Node node = new Node(n);

        if (isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }

        this.size++;
    }

    public void addFirst(int n) {
        Node node = new Node(n);

        if (isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }

        this.size++;
    }

    public void add(int index, int n) {
        if (index < 0 || index > this.size)
            throw new IndexOutOfBoundsException();

        Node node = new Node(n);

        if (index == 0)
            addFirst(n);

        if (index == this.size - 1)
            addLast(n);

        Node aux = this.head;
        for (int i = 0; i < index - 1; i++)
            aux = aux.next;

        node.next = aux.next;
        node.prev = aux;
        aux.next.prev = node;
        aux.next = node;

        this.size++;
    }

    public int getFirst() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();

        return this.head.v;
    }

    public int getLast() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();

        return this.tail.v;
    }

    public int get(int index) {
        if (isEmpty() || index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException();

        Node aux = this.head;

        for (int i = 0; i < index; i++)
            aux = aux.next;

        return aux.v;
    }

    public int getSize() {
        return this.size;
    }

    public int indexOf(int n) {
        if (isEmpty())
            throw new IndexOutOfBoundsException();

        Node aux = this.head;
        int i = 0;

        while (aux.next != null) {
            if (aux.v == n)
                return i;

            aux = aux.next;
            i++;
        }

        return -1;
    }

    public boolean contains(int n) {
        return indexOf(n) != -1;
    }

    public int removeFirst() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();

        this.size--;
        if (this.head.next == null) {
            int n = this.head.v;
            this.head = null;
            this.tail = null;
            return n;
        } else {
            int n = this.head.next.v;
            this.head = this.head.next;
            this.head.prev = null;
            return n;
        }
    }

    public int removeLast() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();

        this.size--;
        if (this.tail.prev == null) {
            int n = this.tail.v;
            this.head = null;
            this.tail = null;
            return n;
        } else {
            int n = this.tail.prev.v;
            this.tail = this.tail.prev;
            this.tail.next = null;
            return n;
        }
    }

    public int remove(int index) {
        if (isEmpty())
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            return removeFirst();
        }
        if (index == this.size - 1) {
            return removeLast();
        }

        Node aux = this.head;
        for (int i = 0; i < index - 1; i++)
            aux = aux.next;

        int n = aux.next.v;

        aux.next = aux.next.next;
        aux.next.prev = aux;

        this.size--;
        return n;
    }

    public boolean gotRemoved(int n) {
        Node aux = this.head;

        for (int i = 0; i < this.size; i++) {
            if (aux.v == n) {
                if (i == 0) removeFirst();
                else if (i == this.size - 1) removeLast();
                else {
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;
                    this.size--;
                }

                return true;
            }
            aux = aux.next;
        }

        return false;
    }
}
