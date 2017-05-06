package com.bat.flipOver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Feng on 2017/3/21.
 * 牛牛正在挑战一款名为01翻转的游戏。游戏初始有A个0,B个1，牛牛的目标就是把所有的值都变为1，
 * 每次操作牛牛可以任意选择恰好K个数字，并将这K个数字的值进行翻转(0变为1，1变为0)。
 * 牛牛如果使用最少的操作次数完成这个游戏就可以获得奖品，牛牛想知道最少的操作次数是多少？
 * 例如:A = 4 B = 0 K = 3
 * 0000 -> 1110 -> 1001 -> 0100 -> 1111
 * 需要的最少操作次数为4
 * <p>
 * 输入描述:
 * 输入为一行：
 * 一共三个整数A(0 ≤ A ≤ 100,000),B(0 ≤ B ≤ 100,000),K(1 ≤ K ≤100,000).以空格分隔
 * <p>
 * 输出描述:
 * 输出一个整数，表示最少需要的操作次数。如果不能完成，则输出-1
 * <p>
 * <p>
 * 输入例子:
 * 4 0 3
 * <p>
 * 输出例子:
 * 4
 */
public class FlipOver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] nums = line.split(" ");
            int A = Integer.parseInt(nums[0]);//初始0的个数
            int B = Integer.parseInt(nums[1]);//初始1的个数
            int K = Integer.parseInt(nums[2]);//选择K个数字进行翻转

            int N = A + B;

            System.out.println(flipOver(A, N, K));
        }
    }

    public static int flipOver(int a, int n, int k) {
        if (a == 0) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        int[] visited = new int[n + 1];
        int[] disk = new int[n + 1];
        //将指定的元素插入此队列（如果立即可行且不会违反容量限制），
        // 当使用有容量限制的队列时，此方法通常要优于 add(E)，后者可能无法插入元素，而只是抛出一个异常。
        queue.offer(a);

        visited[a] = 1;
        disk[a] = 0;
        while (!queue.isEmpty()) {
            int local = queue.remove();
            for (int i = 1; i <= k; i++) {
                if (i <= local && k - i <= n - local) {
                    int next = local - 2 * i + k;
                    if (visited[next] == 0) {
                        if (next == 0) {
                            return disk[local] + 1;
                        }
                        queue.offer(next);
                        visited[next] = 1;
                        disk[next] = disk[local] + 1;
                    }
                }
            }
        }
        return -1;
    }
}
