package sort;

import java.util.Arrays;

/**
 * @author zhaomin
 * @date 2020/7/1 16:17
 */
public class mregeSort {

    public void mergeSort(int[] arr,int left,int right){
        if(left+1>=right) {
            return;
        }
            int mid=(left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr, mid , right);
            merge(arr,left,mid,right);

    }

    private void merge(int[] arr, int left, int mid, int right) {
        int length = right - left;
        int[] temp = new int[length];

        int i = left;
        int j = mid;
        int t = 0;
        while (i < mid && j < right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i < mid) {
            temp[t++] = arr[i++];
        }
        while (j < right) {
            temp[t++] = arr[j++];
        }
        for (int k = 0; k < length; k++) {
            arr[k + left] = temp[k];
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 2, 9, 2, 4, 1, 5, 2, 2, 4};
        mregeSort obj=new mregeSort();
        obj.mergeSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
