package HW02;

import java.util.ArrayList;
import java.util.List;

public class Combination {


    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    /*
     * Given two integers n and k, return all possible combinations of k numbers
     * chosen from the range [1, n].You may return the answer in any order.
     * Input: n = 4, k = 2
     * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
     * Explanation: There are 4 choose 2 = 6 total combinations.
     * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
     */

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generator(1, n, k, new ArrayList<>(), result);
        return result;
    }

    public static void generator(int start, int end, int size, List<Integer> comb, List<List<Integer>> result) {
        if (comb.size() == size) {
            result.add(new ArrayList<>(comb));
        }

        for (int i = start; i <= end; i++) {
            comb.add(i);
            generator(i + 1, end, size, comb, result);
            comb.remove(comb.size() - 1);
        }
    }
}
