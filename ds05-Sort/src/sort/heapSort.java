package sort;

import java.util.Arrays;

/**
 * @author zhaomin
 * @date 2020/7/1 21:36
 */
public class heapSort {
    public static void heapSort(int[] arr){
        creatHeap(arr,arr.length);
        for(int i=0;i<arr.length-1;i++){
            swap(arr,0,arr.length-1-i);
            heapify(arr,arr.length-1-i,0);
        }
    }

    private static void creatHeap(int[] arr, int length) {
        for(int i=(length-2)/2;i>=0;i--){
            heapify(arr,length,i);
        }
    }

    private static void heapify(int[] arr, int length, int index) {
        while(true){
            int left=2*index+1;
            if (left>= length) {
                return;
            }
            int right=2*index+2;

            int maxIndex=left;
            if(right<length&&arr[right]>arr[left]){
                maxIndex=right;
            }
            if (arr[maxIndex] > arr[index]) {
                swap(arr,maxIndex,index);
                index=maxIndex;
            }else{
                break;
            }
        }
    }

    private static void swap(int[] arr, int maxIndex, int index) {
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[index];
        arr[index]=temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 2, 9, 2, 4, 1, 5, 2, 2, 4};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
