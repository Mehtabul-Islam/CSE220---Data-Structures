import java.util.Arrays;
import java.util.Scanner;

class MaxHeap {
    private int[] arr;
    private int size;

    public MaxHeap(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    public void insert(int value) {
        arr[size] = value;
        swim(size);
        size++;
    }

    private void swim(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (arr[index] <= arr[parent]) break;

            swap(index, parent);
            index = parent;
        }
    }

    public int extractMax() {
        if (size == 0) return Integer.MIN_VALUE;

        int max = arr[0];
        arr[0] = arr[size - 1];
        size--;

        sink(0);
        return max;
    }

    private void sink(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < size && arr[left] > arr[largest]) {
                largest = left;
            }

            if (right < size && arr[right] > arr[largest]) {
                largest = right;
            }

            if (largest == index) break;

            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

public class LAB6_Assignment_Task_2 {

    public static int[] findTopK(int[] nums, int k) {

        if (k > nums.length) {
            k = nums.length; 
        }

        MaxHeap heap = new MaxHeap(nums.length);

        for (int num : nums) {
            heap.insert(num);
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = heap.extractMax();
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            nums[i] = scanner.nextInt();
        }

        System.out.println("Enter k:");
        int k = scanner.nextInt();

        int[] result = findTopK(nums, k);

        System.out.println("Top " + k + " largest elements: " + Arrays.toString(result));

        scanner.close(); 
    }
}