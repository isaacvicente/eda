import java.util.*;

class wordCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        HashTable ht = new HashTable();

        for (int i = 0; i < entrada.length; i++) {
            ht.add(entrada[i]);
        }

        String word;
        do {
            word = sc.nextLine();
            if (!word.equals("fim")) {
                System.out.println(ht.get(word));
            }
        } while (!word.equals("fim"));
    }
}

class HashTable {
    final private int LEN = 349;
    private int[] array;

    public HashTable() {
        this.array = new int[this.LEN];
    }

    public void add(String word) {
        this.array[hash(word)]++;
    }

    public int hash(String word) {
        char[] letters = word.toCharArray();

        int sum = 0;
        for (int i = 0; i < letters.length; i++) {
            sum += (int) letters[i];
        }

        return (sum / letters.length) % this.LEN;
    }

    public int get(String word) {
        return this.array[hash(word)];
    }
}
