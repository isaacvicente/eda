import java.util.*;

class maxPilha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays
            .stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        Pilha pilha = new Pilha(array.length);
        Pilha aux = new Pilha(array.length);
        for (int i = array.length - 1; i >= 0; i--) {
            pilha.push(array[i]);
        }
        
        int maior = pilha.peek();
        while (!pilha.isEmpty()) {
            int n = pilha.pop();
            aux.push(n);
            if (n > maior) {
                maior = n;
            }
        }

        while (!aux.isEmpty()) {
            pilha.push(aux.pop());
        }

        System.out.println(maior);
    }
}

class Pilha {
    private int[] pilha;
    private int top;
    private int capacidade;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.pilha = new int[capacidade];
        this.top = -1;
    }
    
    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.capacidade - 1;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }

        return this.pilha[this.top];
    }

    public void push(int n) {
        if (isFull()) {
            throw new RuntimeException("stack is full");
        }

        this.pilha[++this.top] = n;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        
        int n = peek();
        this.top--;

        return n;
    }
}
