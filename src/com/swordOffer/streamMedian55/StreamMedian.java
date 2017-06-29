package com.swordOffer.streamMedian55;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Feng on 2017/6/28.
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class StreamMedian {

    static int count = 0;
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            //PriorityQueue默认是小顶堆，实现大顶堆，需要反转默认排序器
            return o2.compareTo(o1);
        }
    });

    public static void Insert(Integer num) {
        count++;
        if ((count & 1) == 0) { // 判断偶数的高效写法
            //当数据总数为偶数时，新加入的元素，应当进入小根堆
            //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
            //1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            //2.筛选后的【大根堆中的最大元素】进入小根堆
            minHeap.offer(num);
        } else {
            //当数据总数为奇数时，新加入的元素，应当进入大根堆
            //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最小元素进入大根堆）
            //1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            //2.筛选后的【小根堆中的最小元素】进入大根堆
            maxHeap.offer(num);
        }
    }

    public static Double GetMedian() {
        if (count == 0) {
            throw new RuntimeException("no available number!");
        }
        double result;
        //总数为奇数时，大顶堆堆顶就是中位数
        if ((count & 1) == 1) {
            result = maxHeap.peek();
        } else {

            result = (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return result;
    }

    public static void main(String[] args) {
        Insert(3);
        Insert(4);
        Insert(7);
        Insert(6);
        Insert(2);
        Insert(5);
        Insert(9);
        Insert(1);
        Double median = GetMedian();
        System.out.println(median);
    }
}
