import java.util.Scanner;

class torreDeHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int disk = Integer.parseInt(sc.nextLine());

        hanoi(disk, "A", "B", "C");

        sc.close();
    }

    public static void hanoi(int disk, String src, String inter, String dest) {
        if (disk == 1) {
            printMovement(disk, src, dest);
        } else {
            hanoi(disk - 1, src, dest, inter);
            printMovement(disk, src, dest);
            hanoi(disk - 1, inter, src, dest);
        }
    }

    public static void printMovement(int disk, String src, String dest) {
        System.out.println("Move o disco " + disk + " da haste " + src + " para a haste " + dest);
    }
}
