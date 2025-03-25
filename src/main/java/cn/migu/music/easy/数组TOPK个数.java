package cn.migu.music.easy;

import java.util.Arrays;

/**
 * @version 1.0 created by huangfei on 2025/3/21 17:36
 */
public class 数组TOPK个数 {

    // 堆的大小
    private int size;

    // 构建最大堆
    private void buildMaxHeap(int[] arr) {
        size = arr.length;
        // 从最后一个非叶子节点开始调整
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    // 堆化（调整堆）
    private void heapify(int[] arr, int i) {
        int largest = i; // 假设当前节点是最大值
        int left = 2 * i + 1; // 左子节点
        int right = 2 * i + 2; // 右子节点

        // 如果左子节点存在且大于当前节点
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }

        // 如果右子节点存在且大于当前节点
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大值不是当前节点，交换并继续堆化
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest);
        }
    }

    // 交换数组中的两个元素
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 找到前K个最大元素
    public int[] topK(int[] arr, int k) {
        buildMaxHeap(arr); // 构建最大堆
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[0]; // 取出堆顶元素（最大值）
            swap(arr, 0, size - 1); // 将堆顶元素与最后一个元素交换
            size--; // 减少堆的大小
            heapify(arr, 0); // 重新调整堆
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        int k = 3;
        数组TOPK个数 topK = new 数组TOPK个数();
        int[] result = topK.topK(arr, k);
        System.out.println(Arrays.toString(result)); // 输出: [9, 6, 5]
    }
}
