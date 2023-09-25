import java.util.Scanner;

class filaComArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacidade = Integer.parseInt(sc.nextLine());

        Fila fila = new Fila(capacidade);

        while (true) {
            String input = sc.nextLine();
            if (input.equals("end"))
                break;

            String[] arguments = input.split(" ");
            if (arguments.length > 1) {
                if (arguments[0].equals("add")) {
                    try {
                        fila.add(Integer.parseInt(arguments[1]));
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else {
                if (input.equals("print")) {
                    try {
                        System.out.println(fila.print());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (input.equals("element")) {
                    try {
                        System.out.println(fila.head());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (input.equals("remove")) {
                    try {
                        fila.remove();
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}

class Fila {
    private int[] fila;
    private int head, tail, capacidade, elements;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.head = -1;
        this.tail = -1;
        this.fila = new int[capacidade];
    }

    public boolean isEmpty() {
        return this.capacidade == 0 || (this.head == -1 && this.tail == -1);
    }

    public boolean isFull() {
        return this.capacidade == 0 || (this.tail + 1) % this.capacidade == this.head;
    }

    public void add(int n) {
        if (isFull()) {
            throw new RuntimeException("full");
        } else if (isEmpty()) {
            this.head++;
            this.tail++;
            this.fila[this.tail] = n;
            this.elements++;
        } else {
            this.tail = (this.tail + 1) % this.capacidade;
            this.fila[this.tail] = n;
            this.elements++;
        }
    }

    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        } else if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
            this.elements--;
        } else {
            this.head = (this.head + 1) % this.capacidade;
            this.elements--;
        }
    }

    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        } else {
            return this.fila[this.head];
        }
    }

    public String print() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }

        String result = "";

        int aux = this.head;

        for (int i = 0; i < this.elements; i++) {
            if (this.elements == 1) {
                result += this.fila[aux];
            } else if (i == this.elements - 1) {
                result += this.fila[aux];
            } else {
                result += this.fila[aux] + " ";
            }

            aux = (aux + 1) % this.capacidade;
        }

        return result;
    }
}
