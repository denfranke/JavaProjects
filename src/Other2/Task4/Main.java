package Other2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static int func(List<Integer> arr, int sr) {
        int ans = 0;
        for (Integer integer : arr) {
            ans += Math.abs(integer - sr);
        }
        return Math.abs(ans);
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            System.out.println("Укажите имя файла.");
            return;
        }

        String filename = args[0];
        Scanner scanner = new Scanner(new File(filename));

        List<Integer> arr = new ArrayList<>();
        int sum = 0, cnt = 0;
        while (scanner.hasNext()) {
            int a = Integer.parseInt(scanner.next());
            arr.add(a);
            sum += a;
            cnt++;
        }
        int ans = func(arr, sum / cnt);
        System.out.println(ans>20?"20 ходов недостаточно для приведения всех элементов массива к одному числу":ans);
    }
}
