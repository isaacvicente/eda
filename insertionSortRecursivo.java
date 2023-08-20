import java.util.*;

class insertionSortRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays
            .stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int ini, int fim) {
        if (array.length > 1) {
            int menorInd = ini;
            int j = menorInd + 1;
            while (j > 0 && array[j] < array[j-1]) {
                int aux = array[j];
                array[j] = array[j-1];
                array[j-1] = aux;
                j--;
            }
            System.out.println(Arrays.toString(array));

            if (ini + 1 < fim) {
                sort(array, ini + 1, fim);
            }
        }
    }
}
