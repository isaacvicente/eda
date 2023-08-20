import java.util.Scanner;

class vetorCircular {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] array = sc.nextLine().split(" ");
    int num = Integer.parseInt(sc.nextLine());

    int length = array.length;
    int index = 0;
    for (int i = 0; i < num; i++) {
      index = i % length;
      if (i == num - 1) {
        System.out.println(array[index]);
      } else {
        System.out.print(array[index] + " ");
      }
    }
    sc.close();
  }
}
