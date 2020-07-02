package sort;

import java.util.Arrays;

/**
 * @author zhaomin
 * @date 2020/7/1 15:50
 */
public class bubbleSort {
    public void bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            boolean flag=false;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    flag=true;
                }
            }
            if(!flag){
                return;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 2, 9, 2, 4, 1, 5, 2, 2, 4};
        bubbleSort obj=new bubbleSort();
        obj.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
