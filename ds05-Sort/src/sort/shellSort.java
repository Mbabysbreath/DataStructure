package sort;

import java.util.Arrays;

/**
 * @author zhaomin
 * @date 2020/7/1 16:05
 */
public class shellSort {
    public void shellSort(int[] arr){
        for(int gap=arr.length/2;gap>0;gap/=2){
            for(int i=0;i<arr.length-gap;i+=gap){
                int j;
                int val=arr[i+gap];
                for(j=i;j>=0&&val<arr[j];j-=gap){
                   arr[j+gap]=arr[j];
                }
                arr[j+gap]=val;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 2, 9, 2, 4, 1, 5, 2, 2, 4};
        shellSort obj=new shellSort();
        obj.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
