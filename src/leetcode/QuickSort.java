package leetcode;

import java.util.Arrays;

/**
 * @author magaofei
 * @date 2021/9/24
 */
public class QuickSort {
//
//    public static void quickSort(int arr[], int begin, int end) {
//        if (begin < end) {
//            int partitionIndex = partition(arr, begin, end);
//
//            quickSort(arr, begin, partitionIndex-1);
//            quickSort(arr, partitionIndex+1, end);
//        }
//    }
//
//    private static int partition(int arr[], int begin, int end) {
//
//        // 设定基准值
//        int pivot = arr[end];
//        int i = (begin - 1);
//
//        for (int j = begin; j < end; j++) {
//            if (arr[j] <= pivot) {
//                i++;
//
//                int swapTemp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = swapTemp;
//            }
//        }
//
//        int swapTemp = arr[i+1];
//        arr[i+1] = arr[end];
//        arr[end] = swapTemp;
//
//        return i+1;
//    }

    public static int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        // 设定基准值 (pivot)
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[left]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, left, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 1, 4, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
}
