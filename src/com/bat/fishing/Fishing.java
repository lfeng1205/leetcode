package com.bat.fishing;

import java.util.Scanner;

/**
 * Created by Feng on 2017/4/25.
 * 输入描述:
 * 第一行五个整数n,m,x,y,t(1≤n,m,t≤1000,1≤x≤n,1≤y≤m);
 * 接下来为一个n＊m的矩阵，每行m个一位小数，共n行，第i行第j个数代表坐标为(i,j)的格子钓到鱼的概率为p(0≤p≤1)
 * 输出描述:
 * 输出两行。第一行为概率大的人的名字(cc/ss/equal),第二行为这个概率(保留2位小数)
 * 输入例子:
 * 2 2 1 1 1
 * 0.2 0.1
 * 0.1 0.4
 * 输出例子:
 * equal
 * 0.20
 */
public class Fishing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] nums = sc.nextLine().split(" ");//获取第一行5个整数
            int n = Integer.parseInt(nums[0]);
            int m = Integer.parseInt(nums[1]);
            int x = Integer.parseInt(nums[2]) - 1;
            int y = Integer.parseInt(nums[3]) - 1;
            int t = Integer.parseInt(nums[4]);

            double[][] matrix = new double[n][m];
            for (int i = 0; i < n; i++) {
                String[] probability = sc.nextLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Double.parseDouble(probability[j]);
                }
            }

            fish(matrix, matrix[x][y], t);

        }
    }

    /**
     * @param matrix：概率矩阵
     * @param cc：cc的概率
     * @param t：时间t
     */
    private static void fish(double[][] matrix, double cc, int t) {

        double ss = 0.0;//ss的概率

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ss += matrix[i][j];
            }
        }

        //用累加的概率之和除以格子的总数，就是ss在每个格子钓到鱼的平均概率。
        //也就相当于他固定在一个格子上进行钓鱼。这个格子的概率也是固定的
        ss = ss / (matrix.length * matrix[0].length);

        if (ss > cc) {
            System.out.println("ss");

            //因为至少调到一条鱼的情况比较多，所以考虑对立事件，一个鱼也钓不到的情况
            //又因为每分钟钓到鱼和钓不到鱼都是独立事件，互不影响，（感觉又回到高中了 = =）
            //把每分钟钓不到鱼的概率相乘，也就是求它的t次方，就是t分钟钓不到鱼的概率了。
            //最后用1减去这个概率就是能钓到鱼的概率了
            System.out.println(String.format("%.2f", 1 - Math.pow(1 - ss, t)));
        } else if (cc > ss) {
            System.out.println("cc");
            System.out.println(String.format("%.2f", 1 - Math.pow(1 - cc, t)));
        } else {
            System.out.println("equals");
            System.out.println(String.format("%.2f", 1 - Math.pow(1 - cc, t)));
        }
    }
}
