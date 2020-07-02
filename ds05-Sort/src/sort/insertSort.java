package sort;

import java.util.Arrays;

/**
 * @author zhaomin
 * @date 2020/7/1 15:55
 */
public class insertSort {
    public void insertSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int j;
            int val=arr[i+1];
            for(j=i;j>=0&&val<arr[j];j--){

                    arr[j+1]=arr[j];

            }
            arr[j+1]=val;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 2, 9, 2, 4, 1, 5, 2, 2, 4};
        insertSort obj=new insertSort();
        obj.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
