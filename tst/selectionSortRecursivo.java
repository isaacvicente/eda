import java.util.*;

class selectionSortRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays
            .stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int ini, int fim) {
        int menorInd = ini;
        for (int j = ini + 1; j <= fim; j++) {
            if (array[j] < array[menorInd]) {
                menorInd = j;
            }
        }

        int aux = array[ini];
        array[ini] = array[menorInd];
        array[menorInd] = aux;
        System.out.println(Arrays.toString(array));

        if (ini + 1 < fim) {
            sort(array, ini + 1, fim);
        }
    }
}
