import java.util.*;

class remocaoBST {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] array = Arrays
        .stream(sc.nextLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    int[] toBeRemoved = Arrays
        .stream(sc.nextLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    BST bst = new BST();

    for (int i = 0; i < array.length; i++) {
      bst.add(array[i]);
    }

    for (int j = 0; j < toBeRemoved.length; j++) {
      bst.remove(toBeRemoved[j]);
      System.out.println(bst.preOrder());
    }

    sc.close();
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

  public boolean hasOneChild() {
    return hasOneChildAtLeft() || hasOneChildAtRight();
  }

  public boolean hasOneChildAtLeft() {
    return this.left != null && this.right == null;
  }

  public boolean hasOneChildAtRight() {
    return this.right != null && this.left == null;
  }
}

class BST {
  private Node root;
  ArrayList<Node> BFSResult = new ArrayList<>();

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
    if (isEmpty())
      return null;
    return search(n, this.root);
  }

  private Node search(int n, Node node) {
    if (node == null)
      return null;
    if (n == node.v)
      return node;
    if (n < node.v)
      return search(n, node.left);
    else
      return search(n, node.right);
  }

  public Node max() {
    if (isEmpty())
      return null;
    return max(this.root);
  }

  private Node max(Node node) {
    if (node == null)
      return null;
    if (node.right == null) {
      return node;
    }
    return max(node.right);
  }

  public Node min() {
    if (isEmpty())
      return null;
    return min(this.root);
  }

  private Node min(Node node) {
    if (node == null)
      return null;
    if (node.left == null)
      return node;
    return max(node.left);
  }

  public Node sucessor(Node node) {
    if (node == null)
      return null;

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
    if (node == null)
      return null;

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

  public String preOrder() {
    ArrayList<Integer> result = new ArrayList<>();

    if (isEmpty()) {
      return "null";
    }
    preOrder(this.root, result);
    return result.toString();
  }

  public void preOrder(Node node, ArrayList<Integer> array) {
    if (node != null) {
      array.add(node.v);
      preOrder(node.left, array);
      preOrder(node.right, array);
    }
  }

  public void remove(int n) {
    Node node = search(n);
    if (node != null) {
      remove(node);
    }
  }

  public void remove(Node node) {
    if (node.isLeaf()) {
      if (node == this.root) {
        this.root = null;
      } else {
        if (node.v < node.parent.v) {
          node.parent.left = null;
        } else {
          node.parent.right = null;
        }
      }
    } else if (node.hasOneChild()) {
      if (node.hasOneChildAtLeft()) {
        if (node == this.root) {
          this.root = node.left;
          node.parent = null;
        } else {
          node.left.parent = node.parent;
          if (node.v < node.parent.v) {
            node.parent.left = node.left;
          } else {
            node.parent.right = node.left;
          }
        }
      } else if (node.hasOneChildAtRight()) {
        if (node == this.root) {
          this.root = node.right;
          node.parent = null;
        } else {
          node.right.parent = node.parent;
          if (node.v < node.parent.v) {
            node.parent.left = node.right;
          } else {
            node.parent.right = node.right;
          }
        }
      }
    } else {
      Node sucessor = sucessor(node);
      node.v = sucessor.v;

      remove(sucessor);
    }
  }
}
