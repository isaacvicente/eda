import java.util.Scanner;
import java.util.Arrays;

class trocaVizinhos {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] array = sc.nextLine().split(" ");
    int length = array.length;

    boolean par = length % 2 == 0;

    for (int i = 0; i < length - 1; i+= 2) {
      if (i == length - 2) {
        if (par) {
          String tmp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = tmp;
        }
      } else {
        String tmp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = tmp;
      }
    }
    System.out.println(Arrays.toString(array));
    sc.close();
  }
}
