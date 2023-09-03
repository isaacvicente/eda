import java.util.*;

class maxPilhaIndex {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] entrada = Arrays
        .stream(sc.nextLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    int capacidade = entrada.length;
    Pilha pilha = new Pilha(capacidade);

    int ind = Integer.parseInt(sc.nextLine());
    Pilha aux = new Pilha(ind + 1);

    for (int i = 0; i < capacidade; i++) {
      pilha.push(entrada[i]);
    }

    int maior = pilha.peek();

    for (int j = 0; j <= ind; j++) {
      int e = pilha.pop();
      aux.push(e);
      if (e > maior)
        maior = e;
    }

    for (int k = 0; k <= ind; k++) {
      pilha.push(aux.pop());
    }

    System.out.println(maior);

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
