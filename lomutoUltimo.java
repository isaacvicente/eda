import java.util.*;

class lomutoUltimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays
            .stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        partition(array, 0, array.length - 1);
        sc.close();
    }

    public static void partition(int[] v, int left, int right) {
        int pivot = v[right];
        int i = right;

        for (int j = i - 1; j >= 0; j--) {
            if (v[j] >= pivot) {
                swap(v, --i, j);
                System.out.println(Arrays.toString(v));
            }
        }

        swap(v, i, right);
        // Por que dois "prints" repetidos? Não sei.
        System.out.println(Arrays.toString(v));
        System.out.println(Arrays.toString(v));
    }

    public static void swap(int[] a, int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }
}
