import java.util.*;

class invertePilhaIndex {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int capacidade = Integer.parseInt(sc.nextLine());
    Pilha pilha = new Pilha(capacidade);

    int[] array = Arrays
        .stream(sc.nextLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    int ind = Integer.parseInt(sc.nextLine());

    for (int i = capacidade - 1; i >= 0; i--) {
      pilha.push(array[i]);
    }

    Pilha aux = new Pilha(capacidade);
    Pilha result = new Pilha(capacidade);

    for (int j = 0; j < capacidade; j++) {
      if (j < capacidade - 1 - ind) {
        result.push(pilha.pop());
      } else {
        aux.push(pilha.pop());
      }
    }

    for (int k = 0; k <= ind; k++) {
      result.push(aux.pop());
    }

    System.out.println("-");
    for (int i = 0; i < capacidade; i++) {
      System.out.println(result.pop());
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
