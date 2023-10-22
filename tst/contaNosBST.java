import java.util.*;

class contaNosBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays
            .stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        BST bst = new BST();

        for (int i = 0; i < array.length; i++) {
            bst.add(array[i]);
        }

        System.out.println(bst.qntdNosInternos());
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

    public boolean isLeaf() {
        return this.right == null && this.left == null;
    }
}

class BST {
    private Node root;

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
            return max(node.left);
        } else {
            Node aux = node.parent;
            while (aux != null && aux.v > node.v) {
                aux = aux.parent;
            }

            return aux;
        }
    }

    public int qntdNosInternos() {
        return qntdNosInternos(this.root);
    }

    private int qntdNosInternos(Node node) {
        if (isEmpty() || node == null) return 0;
        if (!node.isLeaf()) {
            return 1 + qntdNosInternos(node.left) + qntdNosInternos(node.right);
        } else {
            return 0;
        }
    }
}
