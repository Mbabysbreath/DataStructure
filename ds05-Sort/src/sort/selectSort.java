package sort;

import java.util.Arrays;

/**
 * @author zhaomin
 * @date 2020/7/1 15:53
 */
public class selectSort {
    public void selectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min=arr[i];
            int index=i;
            for(int j=i+1;j<arr.length;j++){
                if(min>arr[j]){
                    min=arr[j];
                    index=j;
                }
            }
            arr[index]=arr[i];
            arr[i]=min;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 2, 9, 2, 4, 1, 5, 2, 2, 4};
        selectSort obj=new selectSort();
        obj.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
