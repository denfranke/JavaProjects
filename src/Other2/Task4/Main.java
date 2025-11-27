package Other2.Task4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int func(List<Integer> arr, int sr) {
        int ans = 0;
        for (Integer integer : arr) {
            ans += Math.abs(integer - sr);
        }
        return Math.abs(ans);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Ошибка: не указано имя файла");
            return;
        }

        String filename = args[0];
        File file = new File(filename);

        if (!file.exists()) {
            System.err.println("Ошибка: файл " + filename + " не найден.");
            return;
        }

        if (!file.canRead()) {
            System.err.println("Ошибка: нет доступа на чтение файла " + filename);
            return;
        }

        List<Integer> arr = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            if (!scanner.hasNext()) {
                System.err.println("Ошибка: файл пуст.");
                return;
            }

            int sum = 0, cnt = 0;
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int a = scanner.nextInt();
                    arr.add(a);
                    sum += a;
                    cnt++;
                } else {
                    System.err.println("Ошибка: обнаружено нецелочисленное значение в файле");
                    return;
                }
            }

            int ans = func(arr, sum / cnt);
            System.out.println(ans > 20 ? "20 ходов недостаточно для приведения всех элементов массива к одному числу" : ans);

        } catch (SecurityException e) {
            System.err.println("Ошибка безопасности при доступе к файлу: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка при чтении файла: " + e.getMessage());
        }
    }
}
