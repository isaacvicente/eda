import java.util.*;

class mergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays
            .stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        sort(array, 0, array.length - 1);
        sc.close();
    }

    public static void sort(int[] v, int left, int right) {
        print(v, left, right);
        if (left < right) {
            int middle = (left + right) / 2;

            sort(v, left, middle);
            sort(v, middle + 1, right);
            merge(v, left, right);
            print(v, left, right);
        }
    }

    public static void merge(int[] v, int left, int right) {
        int[] h = new int[v.length];
        for (int i = 0; i < v.length; i++)
            h[i] = v[i];

        int middle = (left + right) / 2;
        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            if (h[i] < h[j])
                v[k++] = h[i++];
            else
                v[k++] = h[j++];
        }

        while (i <= middle)
            v[k++] = h[i++];
        
        while (j <= right)
            v[k++] = h[j++];
    }

    public static void print(int[] a, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (i == left && i == right)
                System.out.println("[" + a[i] + "]");
            else if (i == left) 
                System.out.print("[" + a[i] + ", ");
            else if (i == right)
                System.out.println(a[i] + "]");
            else
                System.out.print(a[i] + ", ");
        }
    }
}
