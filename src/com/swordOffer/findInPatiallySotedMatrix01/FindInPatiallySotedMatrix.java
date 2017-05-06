package com.swordOffer.findInPatiallySotedMatrix01;

import java.util.Scanner;

/**
 * Created by Feng on 2017/4/30.
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindInPatiallySotedMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int rows = sc.nextInt();//数组行数
            int cols = sc.nextInt();//数组列数
            int target = sc.nextInt();//目标数

            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            System.out.println(find(matrix, rows, cols, target));
        }
    }

    private static boolean find(int[][] matrix, int rows, int cols, int target) {
        boolean found = false;//判断是否找到目标数

        if (matrix != null && rows > 0 && cols > 0) {
            int row = 0;
            int col = cols - 1;
            //从右上角开始查找
            while (row < rows && col >= 0) {
                //如果大于目标数，则查找matrix[row][col]的左边区域
                if (matrix[row][col] > target) {
                    col--;
                    //如果小于于目标数，则查找matrix[row][col]的下l边区域
                } else if (matrix[row][col] < target) {
                    row++;
                } else {
                    found = true;
                    break;
                }
            }
        }

        return found;
    }
}
