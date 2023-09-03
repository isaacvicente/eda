import java.util.*;

class quickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays
            .stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        sort(array, 0, array.length - 1);
        sc.close();
    }

    public static void sort(int[] v, int left, int right) {
        if (left < right) {
            int pivotInd = partition(v, left, right);
            sort(v, left, pivotInd - 1);
            sort(v, pivotInd + 1, right);
        }
    }

    public static int partition(int[] v, int left, int right) {
        int pivot = v[left];
        int i = left;

        for (int j = i + 1; j <= right; j++) {
            if (v[j] <= pivot)
                swap(v, ++i, j);
        }

        swap(v, i, left);
        print(v);
        return i;
    }

    public static void swap(int[] a, int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1)
                System.out.println(a[i]);
            else
                System.out.print(a[i] + " ");
        }
    }
}
