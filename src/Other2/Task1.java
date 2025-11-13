package Other2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String path1 = func(n, m);
        n = scanner.nextInt();
        m = scanner.nextInt();
        String path2 = func(n, m);

        System.out.println(path1 + path2);
    }

    private static String func(int n, int m) {
        String path = "";

        for (int i = 0; i != 0 || path == ""; i = (i + m - 1) % n)
            path = path + (i + 1);

        return path;
    }
}
