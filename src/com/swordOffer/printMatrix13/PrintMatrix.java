package com.swordOffer.printMatrix13;

import java.util.Scanner;

/**
 * Created by Feng on 2017/5/8.
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String nums = sc.nextLine();
            int row = Integer.parseInt(nums.split(" ")[0]);//数组的行数
            int column = Integer.parseInt(nums.split(" ")[1]);//数组的列数

            int[][] matrix = new int[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            printMatrixClockwisely(matrix, column, row);
        }
    }

    public static void printMatrixClockwisely(int[][] marix, int column, int row) {

        //判断是否为空
        if (marix == null || column <= 0 || row <= 0) {
            return;
        }

        int start = 0;
        while (column > start * 2 && row > start * 2) {
            printMatrixInCircle(marix, column, row, start);
            start++;
        }
    }

    public static void printMatrixInCircle(int[][] matrix, int column, int row, int start) {

        int endX = column - 1 - start;
        int endY = row - 1 - start;

        //从左到右打印一行
        for (int i = start; i <= endX; i++) {
            int number = matrix[start][i];
            System.out.print(number + "\t");
        }

        //从上到下打印一列
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                int number = matrix[i][endX];
                System.out.print(number + "\t");
            }
        }

        //从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                int number = matrix[endY][i];
                System.out.print(number + "\t");
            }
        }

        //从下到上打印一列
        if (start < endX && start < endY) {
            for (int i = endY - 1; i >= start + 1; i--) {
                int number = matrix[i][start];
                System.out.print(number + "\t");
            }
        }
    }
}
