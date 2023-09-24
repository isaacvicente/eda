import java.util.*;

class parenteses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split("");
        if (validaParenteses(entrada)) {
            System.out.println("S");
        } else {
            System.out.println("N");
        }

        sc.close();
  }

    public static boolean validaParenteses(String[] entrada) {
        Pilha pilha = new Pilha(entrada.length);

        for (int i = 0; i < entrada.length; i++) {
            if (entrada[i].equals("(")) {
                try {
                    pilha.push(1);
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
            }

            if (entrada[i].equals(")")) {
                try {
                    pilha.pop();
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
            }
        }
        return pilha.isEmpty();
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
      throw new IndexOutOfBoundsException("A pilha está cheia.");
    }
  }
}
