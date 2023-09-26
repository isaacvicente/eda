import java.util.Scanner;

class filaComArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String start = sc.nextLine();

        Fila fila = new Fila(Integer.parseInt(start));

        String[] entrada = new String[2];

        entrada[0] = "";

        while (!entrada[0].equals("end")) {
            entrada = sc.nextLine().split(" ");

            if (entrada[0].equals("add")) {
                fila.add(Integer.parseInt(entrada[1]));
            } else if (entrada[0].equals("remove")) {
                fila.remove();
            } else if (entrada[0].equals("element")) {
                if (fila.tail > -1) {
                    System.out.println(fila.array[0]);
                } else {
                    System.out.println("empty");
                }
            } else if (entrada[0].equals("print")) {
                System.out.println(fila.print());
            }

        }

        sc.close();
    }
}

class Fila {
    int[] array;
    int tail;

    public Fila(int size) {
        this.array = new int[size];
        this.tail = -1;
    }

    public void add(int elem) {
        if (!isFull()) {
            this.array[++this.tail] = elem;
        } else {
            System.out.println("full");
        }
    }

    public void remove() {
        if (!isEmpty()) {
            switchPositions();
            this.tail--;
        } else {
            System.out.println("empty");
        }
    }

    private void switchPositions() {
        if (this.tail > 0) {
            for (int i = 1; i <= this.tail; i++) {
                this.array[i - 1] = this.array[i];
            }
        }
    }

    public boolean isEmpty() {
        return (this.tail == -1);
    }

    public boolean isFull() {
        return (this.tail == this.array.length - 1);
    }

    public String print() {
        String arrayString = "";

        if (isEmpty()) {
            arrayString = "empty";
        } else {
            for (int i = 0; i <= tail; i++) {
                String elem = Integer.toString(this.array[i]);
                arrayString += elem + " ";
            }
        }

        return arrayString.trim();
    }
}
