package sort;

import java.util.Arrays;

/**
 * @author zhaomin
 * @date 2020/7/1 21:21
 */
public class radixSort {
    public void radixSort(int[] arr){
        int max=0;
        for(int num:arr){
            if(max<num){
                max=num;
            }
        }
        int cb=(max+"").length();
        int[][] num=new int[10][arr.length];
        int[] tt=new int[10];
        for(int k=0,n=1;k<cb;k++,n*=10){
            for(int i=0;i<arr.length;i++){
                int nn=arr[i]/n%10;
                num[nn][tt[nn]]=arr[i];
                tt[nn]++;
            }
            int index=0;
            for(int i=0;i<10;i++){
                if(tt[i]!=0){
                    for(int j=0;j<tt[i];j++){
                        arr[index++]=num[i][j];
                    }
                }
            }
            tt=new int[10];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 2, 9, 2, 4, 1, 5, 2, 2, 4};
        radixSort obj=new radixSort();
        obj.radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
