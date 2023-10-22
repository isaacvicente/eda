import java.util.*;

class predecessorBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays
            .stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        int value = Integer.parseInt(sc.nextLine());
        BST bst = new BST();

        for (int i = 0; i < array.length; i++) {
            bst.add(array[i]);
        }

        bst.predecessor(bst.search(value));

        System.out.println(bst.predecessorResult.toString());
    }
}

class Node {
    int v;
    Node right;
    Node left;
    Node parent;

    public Node(int v) {
        this(v, null, null, null);
    }

    public Node(int v, Node left, Node right, Node parent) {
        this.v = v;
        this.left = left;
        this.right = right;
        this.right = parent;
    }
}

class BST {
    private Node root;
    ArrayList<Integer> predecessorResult = new ArrayList<>();

    public boolean isEmpty() {
        return this.root == null;
    }
    
    public void add(int n) {
        if (isEmpty()) {
            this.root = new Node(n);
        } else {
            add(n, this.root);
        }
    }

    private void add(int n, Node node) {
        if (n > node.v) {
            if (node.right == null) {
                Node newNode = new Node(n);
                node.right = newNode;
                newNode.parent = node;
            } else {
                add(n, node.right);
            }
        } else {
            if (node.left == null) {
                Node newNode = new Node(n);
                node.left = newNode;
                newNode.parent = node;
            } else {
                add(n, node.left);
            }
        }
    }

    public Node search(int n) {
        if (isEmpty()) return null;
        return search(n, this.root);
    }

    private Node search(int n, Node node) {
        if (node == null) return null;
        if (n == node.v) return node;
        if (n < node.v) return search(n, node.left);
        else return search(n, node.right);
    }

    public Node max() {
        if (isEmpty()) return null;
        return max(this.root);
    }

    private Node max(Node node) {
        if (node == null) return null;
        if (node.right == null) {
            return node;
        }
        predecessorResult.add(Integer.valueOf(max(node.right).v));
        return max(node.right);
    }

    public Node min() {
        if (isEmpty()) return null;
        return min(this.root);
    }

    private Node min(Node node) {
        if (node == null) return null;
        if (node.left == null) return node;
        return max(node.left);
    }

    public Node sucessor(Node node) {
        if (node == null) return null;

        if (node.right != null) {
            return min(node.right);
        } else {
            Node aux = node;
            while (aux != null && aux.v < node.v) {
                aux = aux.parent;
            }

            return aux;
        }
    }

    public Node predecessor(Node node) {
        if (node == null) return null;

        if (node.left != null) {
            predecessorResult.add(Integer.valueOf(node.v));
            predecessorResult.add(Integer.valueOf(node.left.v));
            return max(node.left);
        } else {
            Node aux = node.parent;
            predecessorResult.add(Integer.valueOf(node.v));
            while (aux != null && aux.v > node.v) {
                predecessorResult.add(Integer.valueOf(aux.v));
                aux = aux.parent;
            }

            if (aux != null)
                predecessorResult.add(Integer.valueOf(aux.v));
            else
                this.predecessorResult = new ArrayList<>();

            return aux;
        }
    }
}
