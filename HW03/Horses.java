package HW03;

import java.util.Arrays;

public class Horses {
    /*
     * * Шахматную доску размером NxN обойти конём так, чтобы фигура в каждой клетке была строго один раз.
     */
    static int size = 5;
    static int[][] steps = {
            {-2, -1},
            {-2, 1},
            {-1, -2},
            {-1, -2},
            {1, -2},
            {1, 2},
            {2, -1},
            {2, 1}
    };


    public static void main(String[] args) {
        int[][] chessBoard = new int[size][size];
        int rowStart = 2;
        int colStart = 2;
        chessBoard[rowStart][colStart] = 1;
        solveHorses(chessBoard, rowStart, colStart, 1);
        print(chessBoard); //проверка
    }

    public static boolean solveHorses(int[][] board, int row, int col, int numberStep) {

        if (numberStep == size * size) {
            print(board); // не выводит
            return false;
        }

        for (int[] step : steps) {
            int newRow = row + step[0];
            int newCol = col + step[1];
            int newStep = numberStep + 1;

            if (isValid(board, newRow, newCol)) {
                board[newRow][newCol] = newStep;
                if (solveHorses(board, newRow, newCol, newStep)) {
                    return true;
                } else {
                    board[newRow][newCol] = 0;
                }
            }
        }

        return false;
    }

    public static boolean isValid(int[][] board, int row, int col) {
        if (row >= size || row < 0) return false;
        if (col >= size || col < 0) return false;
        return board[row][col] == 0;
    }

    public static void print(int[][] arr) {
        for (int[] line : arr) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println();
    }
}
