package veritas;

import java.util.PriorityQueue;

public class Problem_1 {
    public static int problem1 (int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : arr) {
            heap.offer(num);
        }

        while (heap.size() > 1) {
            heap.offer(2 * heap.poll() + 2 * heap.poll());
        }
        return heap.poll();
    }

    public static void main(String[] args) {
        int[] arr = {-3, -42, 42, 54, 644, 0, 1, 1, 1, 431, 542 ,65, 12};
        int[] arr2 = {1,2,3,4,5};
        System.out.println(problem1(arr2));
    }
}
