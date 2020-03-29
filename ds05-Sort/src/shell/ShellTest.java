package shell;

import java.util.Arrays;

/**
 * @author zhaomin
 * @date 2020/3/29 14:01
 */
public class ShellTest {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for(int i=0;i<80000;i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        long start=System.currentTimeMillis();
        shell(arr);
        long end=System.currentTimeMillis();
        System.out.println(end-start);

        long start1=System.currentTimeMillis();
        int[] arr1=new int[]{9,8,6,5,1,0};
        shell2(arr);
        long end1=System.currentTimeMillis();
        System.out.println(end1-start1);
    }
    //第一种希尔排序，有序序列插入采用交换法
    public static void shell(int arr[]){
        int temp=0;
        //gap---分组的个数，每次除以2
        for(int gap=arr.length/2;gap>0;gap/=2) {
            //循环次数
            for(int i=gap;i<arr.length;i++) {
                //每组内部循环
                for(int j=i-gap;j>=0;j-=gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(arr));
    }

    //改进--进行插入
    public static void shell2(int[] arr) {
        for(int gap=arr.length/2;gap>0;gap/=2) {
            for(int i=gap;i<arr.length;i++) {
                int j=i;
                int temp=arr[j];

                if(arr[j]<arr[j-gap]){
                    while (j-gap >= 0 && temp < arr[j - gap]) {
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                }
                 arr[j]=temp;
            }
        }
      //  System.out.println(Arrays.toString(arr));
    }
}
