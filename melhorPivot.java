import java.util.*;

class melhorPivot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays
            .stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        int[] candidatos = Arrays
            .stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        int c1 = candidatos[0];
        int c2 = candidatos[1];

        int i1 = 0;
        int i2 = 0;
        int j1 = 0;
        int j2 = 0;

        for (int k = 0; k < array.length; k++) {
            if (k != c1) {
                if (array[k] < array[c1])
                    i1++;
                else if (array[k] > array[c1])
                    j1++;
                else {
                    if (k < c1)
                        i1++;
                    else
                        j1++;
                }
            }

            if (k != c2) {
                if (array[k] < array[c2])
                    i2++;
                else if (array[k] > array[c2])
                    j2++;
                else {
                    if (k < c2)
                        i2++;
                    else
                        j2++;
                }
            }
        }

        if (Math.abs(i1 - j1) <= Math.abs(i2 - j2))
            System.out.println(c1);
        else
            System.out.println(c2);
    }
}
