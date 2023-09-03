import java.util.*;

class downN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays
            .stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        int n = Integer.parseInt(sc.nextLine());
        sort(array, 0, array.length - 1);

        String r = "";

        for (int i = 0; i < n; i++) {
            r += array[i] + " ";
        }

        System.out.println(r.trim());

        sc.close();
    }

    public static void sort(int[] v, int left, int right) {
        if (left < right) {
            int i = partition(v, left, right);
            
            sort(v, left, i - 1);
            sort(v, i + 1, right);
        }
    }

    public static int partition(int[] v, int left, int right) {
        int range = right - left + 1;
        int rand_pivot_index = (int)(Math.random() * range) + left;

        swap(v, left, rand_pivot_index);

        int pivot = v[left];
        int i = left;

        for (int j = i + 1; j <= right; j++) {
            if (v[j] < pivot)
                swap(v, ++i, j);
        }

        swap(v, i, left);

        return i;
    }


    public static void swap(int[] a, int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }
}

