import java.util.*;

class estatisticaOrdem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays
            .stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        System.out.println(partition(array) + 1);
        sc.close();
    }

    public static int partition(int[] v) {
        int pivot = v[0];
        int i = 0;

        for (int j = i + 1; j < v.length; j++) {
            if (v[j] < pivot)
                swap(v, ++i, j);
        }

        swap(v, i, 0);

        return i;
    }


    public static void swap(int[] a, int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }
}

