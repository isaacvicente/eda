import java.util.*;

class mariana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().split(",");

        for (int i = 0; i < array.length - 1; i++) {
            System.out.println(showBooks(array));
            int j = i + 1;
            while (j > 0 && array[j].compareTo(array[j - 1]) < 0) {
                String aux = array[j];
                array[j] = array[j - 1];
                array[j - 1] = aux;
                j--;
            }
            if (i == array.length - 2)
                System.out.println(showBooks(array));
        }
    }

    public static String showBooks(String[] v) {
        String output = "";
        for (int i = 0; i < v.length; i++) {
            if (i == v.length - 1) {
                output += v[i];
            } else {
                output += v[i] + ", ";
            }
        }
        return output;
    }
}
