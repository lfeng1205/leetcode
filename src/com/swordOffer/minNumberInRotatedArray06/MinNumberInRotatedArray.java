package com.swordOffer.minNumberInRotatedArray06;

import java.util.Scanner;

/**
 * Created by Feng on 2017/5/2.
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotatedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//数组的大小
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }

            int result = minNumberInRotateArray(array);
            System.out.println(result);
        }
    }

    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int low = 0;
        int high = array.length - 1;
        int mid = low;
        while (array[low] >= array[high]) {

            //如果数组只有两个元素
            if (high - low == 1) {
                mid = high;
                break;
            }

            mid = (low + high) / 2;
            //如果mid所对应的值大于low所对应的值，最小的值一定在mid后面
            if (array[mid] >= array[low]) {
                low = mid;
                //如果mid所对应的值小于high所对应的值，最小的值一定在mid前面
            } else if (array[mid] <= array[high]) {
                high = mid;
            }
        }

        return array[mid];
    }
}
