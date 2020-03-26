package bubbleSort;

import java.util.Arrays;

/**
 * @author zhaomin
 * @date 2020/3/25 21:45
 */
public class SortTest {
    public static void main(String[] args) {
        int[] arr=new int[80000];
        for(int i=0;i<80000;i++) {
            arr[i]=(int)(Math.random()*80000);
        }
        long start=System.currentTimeMillis();
        bubbleSorts(arr);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        //System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSorts(int[] arr){
        int temp=0;
        for(int i=0;i<arr.length-1;i++) {
            boolean flag=false;
            for(int j=0;j<arr.length-1-i;j++) {
                if (arr[j] > arr[j + 1]) {
                    flag=true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1]=temp;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
