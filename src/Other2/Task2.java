package Other2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            System.out.println("Укажите имя файла.");
            return;
        }

        String filename = args[0];//"src/Other2/file1.txt"

        Scanner scanner = new Scanner(new File(filename));
        int centerX = Integer.parseInt(scanner.next());
        int centerY = Integer.parseInt(scanner.next());
        int Rx = Integer.parseInt(scanner.next());
        int Ry = Integer.parseInt(scanner.next());

        filename = args[1];//"src/Other2/file2.txt"
        scanner = new Scanner(new File(filename));

        while (scanner.hasNext()) {
            int x = Integer.parseInt(scanner.next());
            int y = Integer.parseInt(scanner.next());

            int position = func(x, y, centerX, centerY, Rx, Ry);
            System.out.println(position);
        }
    }

    private static int func(int x, int y, int cx, int cy, int a, int b) {
        double value = Math.pow(x - cx, 2) / Math.pow(a, 2) + Math.pow(y - cy, 2) / Math.pow(b, 2);

        if (Math.abs(value - 1) < 1e-9)
            return 0;
        else if (value < 1)
            return 1;
        return 2;
    }
}
