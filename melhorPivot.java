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

        System.out.println(melhorPivot(array, c1, c2));
    }

    private static int melhorPivot(int[] array, int i, int j) {
        int countI = 0;
        int countJ = 0;

        for (int k = 0; k < array.length; k++) {
            if (array[k] < array[i]) {
                countI++;
            } else if (array[k] > array[i]) {
                countI--;
            }
            if (array[k] < array[j]) {
                countJ++;
            } else if (array[k] > array[j]) {
                countJ--;
            }
        }

        if (Math.abs(countI) <= Math.abs(countJ)) {
            return i;
        } else {
            return j;
        }
    }
}
