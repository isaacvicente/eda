import java.util.Scanner;

class warmUp {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num = Integer.parseInt(sc.nextLine());
    String[] array = sc.nextLine().split(" ");

    int length = array.length;
    for (int i = 0; i < length; i++) {
      if (i == length - 1) {
        System.out.println(Integer.valueOf(array[i]) * num);
      } else {
        System.out.print(Integer.valueOf(array[i]) * num + " ");
      }
    }
    sc.close();
  }
}
