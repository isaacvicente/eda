import java.util.*;

class ordenaPilhaInvertendo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int capacidade = Integer.parseInt(sc.nextLine());

    int[] entrada = Arrays
        .stream(sc.nextLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    Pilha pilha = new Pilha(capacidade);
    Pilha aux = new Pilha(capacidade);

    for (int i = capacidade - 1; i >= 0; i--) {
      pilha.push(entrada[i]);
      aux.push(entrada[i]);
    }

    Pilha sorted = new Pilha(capacidade);
    int iguais = 0;

    for (int i = capacidade - 1; i >= 0; i--) {
      if (i == 0) {
        sorted.push(aux.pop());
      } else {
        int maior = getMax(i, aux, capacidade);
        sorted.push(maior);

        Pilha tmp = new Pilha(i);
        iguais = 0;
        for (int k = 0; k < i + 1; k++) {
          int e = aux.pop();
          if (e < maior) {
            tmp.push(e);
          }
          if (e == maior) {
            iguais++;
          }
        }

        for (int k = 1; k < iguais; k++) {
          tmp.push(maior);
        }

        aux = tmp;
      }
    }

    System.out.println("-");
    for (int k = 0; k < capacidade; k++) {
      System.out.println(sorted.pop());
    }

    sc.close();
  }

  public static int getMax(int ind, Pilha pilha, int capacidade) {
    Pilha aux = new Pilha(ind + 1);

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

    return maior;
  }

  public static Pilha inverte(int ind, Pilha pilha, int capacidade) {
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

    return result;
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
