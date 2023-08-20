import java.util.*;

class selectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays
            .stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();


        for (int i = 0; i < array.length; i++) {
            int menorInd = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[menorInd]) {
                    menorInd = j;
                }
            }

            if (menorInd != i) {
                int aux = array[i];
                array[i] = array[menorInd];
                array[menorInd] = aux;

                System.out.println(Arrays.toString(array));
            }
        }
    }
}
