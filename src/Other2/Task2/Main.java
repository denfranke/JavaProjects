package Other2.Task2;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Ошибка: требуется два аргумента — пути к двум файлам");
            return;
        }

        String filename1 = args[0];//"src/Other2/file1.txt"
        String filename2 = args[1];//"src/Other2/file2.txt"

        File file1 = new File(filename1);
        File file2 = new File(filename2);

        if (!file1.exists()) {
            System.err.println("Ошибка: не найден  " + filename1);
            return;
        }
        if (!file1.canRead()) {
            System.err.println("Ошибка: нет доступа для чтения  " + filename1);
            return;
        }

        if (!file2.exists()) {
            System.err.println("Ошибка: не найден  " + filename2);
            return;
        }
        if (!file2.canRead()) {
            System.err.println("Ошибка: нет доступа для чтения  " + filename2);
            return;
        }

        Scanner scanner;
        int centerX, centerY, Rx, Ry;

        try {
            scanner = new Scanner(file1);
            if (!scanner.hasNextInt()) {
                System.err.println("Ошибка: в файле " + filename1 + " ожидается целое число (координата центра X)");
                return;
            }
            centerX = scanner.nextInt();

            if (!scanner.hasNextInt()) {
                System.err.println("Ошибка: в файле " + filename1 + " ожидается целое число (координата центра Y)");
                return;
            }
            centerY = scanner.nextInt();

            if (!scanner.hasNextInt()) {
                System.err.println("Ошибка: в файле " + filename1 + " ожидается целое число (координаты радиуса X)");
                return;
            }
            Rx = scanner.nextInt();

            if (!scanner.hasNextInt()) {
                System.err.println("Ошибка: в файле " + filename1 + " ожидается целое число (координаты радиуса Y)");
                return;
            }
            Ry = scanner.nextInt();

            if (Rx <= 0 || Ry <= 0) {
                System.err.println("Ошибка: отрицательное число");
                return;
            }
        } catch (Exception e) {
            System.err.println("Ошибка при чтении файла " + filename1 + ": " + e.getMessage());
            return;
        }

        try {
            scanner = new Scanner(file2);

            while (scanner.hasNext()) {
                if (!scanner.hasNextInt()) {
                    System.err.println("Ошибка: в файле " + filename2 + " обнаружено нецелое значение (ожидается X)");
                    scanner.close();
                    return;
                }
                int x = Integer.parseInt(scanner.next());

                if (!scanner.hasNextInt()) {
                    System.err.println("Ошибка: в файле " + filename2 + " обнаружено нецелое значение (ожидается Y)");
                    scanner.close();
                    return;
                }
                int y = Integer.parseInt(scanner.next());

                int position = func(x, y, centerX, centerY, Rx, Ry);
                System.out.println(position);
            }
        } catch (Exception e) {
            System.err.println("Ошибка при чтении файла " + filename2 + ": " + e.getMessage());
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
