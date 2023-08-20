import java.util.*;

class inserePrimeiro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays
            .stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        int i = 0;
        while (i < array.length - 1 && array[i] > array[i + 1]) {
            int aux = array[i];
            array[i] = array[i + 1];
            array[i + 1] = aux;
            i++;
        }

        System.out.println(Arrays.toString(array));
    }
}
