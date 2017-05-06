package com.bat.eatFish;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/10.
 * 牛牛有一个鱼缸。鱼缸里面已经有n条鱼，每条鱼的大小为fishSize[i] (1 ≤ i ≤ n,均为正整数)，
 * 牛牛现在想把新捕捉的鱼放入鱼缸。鱼缸内存在着大鱼吃小鱼的定律。经过观察，
 * 牛牛发现一条鱼A的大小为另外一条鱼B大小的2倍到10倍(包括2倍大小和10倍大小)，鱼A会吃掉鱼B。
 * 考虑到这个，牛牛要放入的鱼就需要保证：
 * 1、放进去的鱼是安全的，不会被其他鱼吃掉
 * 2、这条鱼放进去也不能吃掉其他鱼
 * 鱼缸里面已经存在的鱼已经相处了很久，不考虑他们互相捕食。现在知道新放入鱼的大小范围minSize,maxSize,
 * 牛牛想知道有多少种大小的鱼可以放入这个鱼缸,
 * 输入描述
 * <p>
 * 输入数据包括3行.
 * 第一行为新放入鱼的尺寸范围minSize,maxSize(1 ≤ minSize,maxSize ≤ 1000)，以空格分隔。
 * 第二行为鱼缸里面已经有鱼的数量n(1 ≤ n ≤ 50)
 * 第三行为已经有的鱼的大小fishSizei，以空格分隔。
 * <p>
 * 输出描述
 * <p>
 * 输出有多少种大小的鱼可以放入这个鱼缸。考虑鱼的大小都是整数表示
 */
public class EatFish {
    public static void main(String[] args) {
        //输入数据
        Scanner sc = new Scanner(System.in);

        //输入尺寸范围
        String size = sc.nextLine();
        String[] sizes = size.split(" ");

        //后放鱼的最小值
        int minSize = Integer.parseInt(sizes[0]);
        //后放鱼的最大值
        int maxSize = Integer.parseInt(sizes[1]);

        //浴池中鱼的数目
        int fishCount = sc.nextInt();

        //还可以放的鱼的数目
        int fishInCount = 0;

        //记录鱼缸中每条鱼的大小
        int[] fishes = new int[fishCount];
        int p = 0;//标记每条鱼
        while (p < fishCount && sc.hasNext()) {
            fishes[p] = sc.nextInt();
            p++;
        }

        for (int i = minSize; i <= maxSize; i++) {
            if (compareTo(i, fishes)) {
                fishInCount++;
            }
        }
        System.out.println(fishInCount);
    }

    public static boolean compareTo(int size, int[] fishes) {
        int tag = 0;//记录池中鱼的数目
        for (int i = 0; i < fishes.length; i++) {
            //同时满足两个条件
            if ((size > fishes[i] * 10 || size < fishes[i] * 2) &&
                    (fishes[i] > size * 10 || fishes[i] < size * 2)) {
                tag++;
                if (tag == fishes.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
