package sort;

import java.util.Arrays;

/**
 * @author zhaomin
 * @date 2020/7/1 16:08
 */
public class quickSort {
    public void quickSort(int[] arr,int left,int right){
        if(left<right){
            int pivot=partition(arr,left,right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr,pivot+1,right);
        }
    }

    private int partition(int[] arr, int left, int right) {

            int less=left;
            int great=right;
            int pivot=arr[right];
        while(less<great){
            while (less < great && arr[less] <= pivot) {
                less++;
            }
            arr[great]=arr[less];
            while(less<great&&arr[great]>=pivot){
                great--;
            }
            arr[less]=arr[great];

        }
        arr[less]=pivot;
        return less;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 2, 9, 2, 4, 1, 5, 2, 2, 4};
        quickSort obj=new quickSort();
        obj.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}

