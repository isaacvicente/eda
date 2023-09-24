import java.util.*;

class furaFila {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] array = Arrays
            .stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        int ind = Integer.parseInt(sc.nextLine());

        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        for (int i = 0; i < array.length; i++) {
            list1.insertLast(array[i]);
        }

        for (int j = ind; j < array.length; j++) {
            list2.insertLast(list1.remove(array[j]));
            System.out.println("[" + list2.print() + ", " + list1.print() + "]");
        }
    }
}

class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void insertLast(int n) {
        Node newNode = new Node(n);

        if (isEmpty()) {
            this.head = newNode;
        } else {
            Node aux = this.head;
            while (aux.next != null) {
                aux = aux.next;
            }

            aux.next = newNode;
        }
        this.size++;
    }

    public String print() {
        String result = "";
        if (isEmpty()) {
            return result;
        } else {
            Node aux = this.head;

            for (int i = 0; i < getSize(); i++) {
                if (getSize() == 1 || i == getSize() - 1) {
                    result += aux.v;
                } else {
                    result += aux.v + ", ";
                }
                aux = aux.next;
            }
        }

        return result;
    }

    public int remove(int e) {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty, cannot remove " + e);
        }

        int v = -1;

        if (this.head.v == e) {
            v = this.head.v;
            if (this.head.next == null) {
                this.head = null;
            } else {
                this.head = this.head.next;
            }
        } else {
            Node aux = this.head;
            while (aux.next != null && aux.next.v != e) {
                aux = aux.next;
            }

            if (aux.next != null) {
                v = aux.next.v;
                aux.next = aux.next.next;
            }
        }
        this.size--;
        return v;
    }

    public int getSize() {
        return this.size;
    }
}

class Node {
    int v;
    Node next;

    public Node(int n) {
        this.v = n;
    }
}
