public class seminar2 {
    public static void main(String[] args) {
        // System.out.println(pow(0, 0));
        // pathFinder(1, 10, 2, 2, 0, "");
        hanoi(3, "1", "2", "3");
    }

    /*
     * Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя
     * количество выполняемых действий к минимуму.
     * Пример 1: а = 3, b = 2, ответ: 9
     * Пример 2: а = 2, b = -2, ответ: 0.25
     * Пример 3: а = 3, b = 0, ответ: 1
     * Пример 4: а = 0, b = 0, ответ: не определено
     */

    public static double pow(int a, int b) {
        return pow(a, b);
    }

    public static double pow(double a, int b) {
        if (b < 0) {
            a = 1 / a;
            b *= -1;
        }
        if (a == 0) {
            return 0;
        }
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        double result = pow(a, b / 2);
        if (b % 2 == 0) {
            return result * result;
        } else {
            return result * result * a;
        }
    }

    /*
     * На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть
     * две команды
     * - команда 1 (к1): увеличить в с раза, а умножается на c
     * - команда 2 (к2): увеличить на d ( +2 ), к a прибавляется d
     * написать программу, которая выдаёт набор команд, позволяющий число a
     * превратить в число b или сообщить, что это невозможно
     * Пример 1: а = 1, b = 7, c = 2, d = 1
     * ответ: к1, к1, к1, к1, к1, к1 или к1, к2, к1, к1, к1 или к1, к1, к2, к1.
     * Пример 2: а = 11, b = 7, c = 2, d = 1
     * ответ: нет решения.
     * Подумать над тем, как сделать минимальное количество команд
     */

    public static void pathFinder(int a, int b, int c, int d, int len, String path) {
        if (a > b)
            return;
        if (a == b) {
            System.out.println(path + "; шагов -> " + len);
            return;
        }
        len++;
        pathFinder(a * c, b, c, d, len, path + " k1");
        pathFinder(a + d, b, c, d, len, path + " k2");
    }

    /*
     * Написать программу, показывающую последовательность действий для игры
     * “Ханойская башня”
     */
    public static void hanoi(int disk, String source, String dest, String buffer) {
        if (disk == 1) {
            System.out.println("Переместите диск " + disk + " c " + source + " на " + dest);
            return;
        }
        hanoi(disk - 1, source, dest, buffer);
        System.out.println("Переместите диск " + disk + " c " + source + " на " + dest);
        hanoi(disk - 1, source, dest, buffer);
    }
}
