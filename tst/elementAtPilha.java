import java.util.*;

class elementAtPilha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays
            .stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        int ind = Integer.parseInt(sc.nextLine());

        if (ind >= 0 && ind < array.length) {
            Pilha p1 = new Pilha(array.length);
            Pilha p2 = new Pilha(array.length);
            for (int i = array.length - 1; i >= 0; i--) {
                p1.push(array[i]);
            }

            for (int j = 0; j <= ind; j++) {
                p2.push(p1.pop());
            }

            System.out.println(p2.peek());

            for (int k = 0; k <= ind; k++) {
                p1.push(p2.pop());
            }
        } else {
            System.out.println("indice invalido");
        }

        sc.close();
    }
}

class Pilha {
  private int[] pilha;
  private int capacidade;
  private int topo;

  public Pilha(int capacidade) {
    this.capacidade = capacidade;
    this.pilha = new int[capacidade];
    this.topo = -1;
  }

  public boolean isFull() {
    return this.topo == this.capacidade - 1;
  }

  public boolean isEmpty() {
    return this.topo == -1;
  }

  public int peek() {
    if (!isEmpty())
      return this.pilha[this.topo];
    throw new IndexOutOfBoundsException("A pilha está vazia.");
  }

  public int pop() {
    if (!isEmpty()) {
      int e = this.pilha[this.topo];
      this.topo--;
      return e;
    } else {
      throw new IndexOutOfBoundsException("A pilha está vazia.");
    }
  }

  public void push(int e) {
    if (!isFull()) {
      this.pilha[++this.topo] = e;
    } else {
      throw new IndexOutOfBoundsException("A pilha está vazia.");
    }
  }
}
