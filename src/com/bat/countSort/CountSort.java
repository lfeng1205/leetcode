package com.bat.countSort;

/**
 * Created by Feng on 2017/4/12.
 * 算法步骤
 * 1.找出待排序的数组中最大和最小的元素
 * 2.统计数组中每个值为i的元素出现的次数，存入数组 C 的第 i 项
 * 3.对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）
 * 4.反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1
 */
public class CountSort {
    public static void main(String[] args) {
        //排序的数组
        int a[] = {1, 5, 6, 3, 8};
        int b[] = countSort(a);
        for (int i : b) {
            System.out.print(i + "");
        }
        System.out.println();
    }

    public static int[] countSort(int[] a) {
        int b[] = new int[a.length];
        int max = a[0], min = a[0];
        for (int i : a) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        //这里k的大小是要排序的数组中，元素大小的极值差+1
        int k = max - min + 1;
        int c[] = new int[k];
        for (int i = 0; i < a.length; ++i) {
            c[a[i] - min] += 1;//优化过的地方，减小了数组c的大小,统计每个数出现的次数
        }
        for (int i = 1; i < c.length; ++i) {
            c[i] = c[i] + c[i - 1];
        }
        for (int i = a.length - 1; i >= 0; --i) {
            b[--c[a[i] - min]] = a[i];//按存取的方式取出c的元素
        }
        return b;
    }
}
