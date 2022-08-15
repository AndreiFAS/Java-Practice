import java.util.ArrayList;
import java.util.List;

public class seminar3 {

    /*
     * Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть
     * заменены знаком вопроса,
     * например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
     * Предложить хотя бы одно решение или сообщить, что его нет.
     */

    static List<String> ans = new ArrayList<>();
    static char[] equation;
    static List<Integer> signIndexes = new ArrayList<Integer>();

    public static void main(String[] args) {
        String eq = "?? + ?? = 69";
        solveEquation(eq);

        for (String string : ans) {
            System.out.println(string);
        }
    }

    private static void solveEquation(String eq) {
        equation = eq.replaceAll("\\s+", "").toCharArray();

        for (int i = 0; i < equation.length; i++) {
            if (equation[i] == '?')
                signIndexes.add(i);
        }

        genComb(signIndexes.size(), new ArrayList<>());
    }

    private static void genComb(int k, List<Character> curComb) {
        if (curComb.size() == k) {
            checkComb(curComb);
            return;
        }

        for (char i = '0'; i <= '9'; i++) {
            curComb.add(i);
            genComb(k, curComb);
            curComb.remove(curComb.size() - 1);
        }
    }

    private static void checkComb(List<Character> curComb) {
        for (int i = 0; i < signIndexes.size(); i++) {
            equation[signIndexes.get(i)] = curComb.get(i);
        }
        int index = 0;
        int q = 0, w = 0, e = 0;
        while (equation[index] != '+') {
            q = q * 10 + (equation[index] - '0');
            index++;
        }
        index++;
        while (equation[index] != '=') {
            w = w * 10 + (equation[index] - '0');
            index++;
        }
        index++;
        while (index < equation.length) {
            e = e * 10 + (equation[index] - '0');
            index++;
        }
        if (q + w == e) {
            ans.add(String.format("%d + %d = %d", q, w, e));
        }
    }
}
