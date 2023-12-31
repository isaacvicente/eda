import java.util.*;

class invertePilha {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int capacidade = Integer.parseInt(sc.nextLine());
    Pilha pilha = new Pilha(capacidade);

    int[] array = Arrays
        .stream(sc.nextLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    for (int i = 0; i < capacidade; i++) {
      pilha.push(array[i]);
    }

    Pilha aux = new Pilha(capacidade);

    for (int j = 0; j < capacidade; j++) {
        aux.push(pilha.pop());
    }

    for (int k = 0; k < capacidade; k++) {
        int e = aux.pop();
        pilha.push(e);
        System.out.println(e);
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
