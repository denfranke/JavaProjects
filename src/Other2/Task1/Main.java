package Other2.Task1;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 4) {
                System.err.println("Использование: java Main <n1> <m1> <n2> <m2>\nПример: java Main 5 3 4 2");
                return;
            }
            //Scanner scanner = new Scanner(System.in);

            int n1 = Integer.parseInt(args[0]);
            int m1 = Integer.parseInt(args[1]);
            int n2 = Integer.parseInt(args[2]);
            int m2 = Integer.parseInt(args[3]);

            if (n1 <= 0 || m1 <= 0 || n2 <= 0 || m2 <= 0) {
                System.err.println("Ошибка: все параметры должны быть положительными числами.");
                return;
            }

            String path1 = func(n1, m1);
            String path2 = func(n2, m2);

            System.out.println(path1 + path2);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: все аргументы должны быть целыми числами.");
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }

    private static String func(int n, int m) {
        String path = "";

        for (int i = 0; i != 0 || path == ""; i = (i + m - 1) % n)
            path = path + (i + 1);

        return path;
    }
}
