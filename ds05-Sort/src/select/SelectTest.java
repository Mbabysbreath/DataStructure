package select;


import java.util.Arrays;

/**
 * @author zhaomin
 * @date 2020/3/26 20:51
 */
public class SelectTest {
    public static void main(String[] args) {
        int[] arr=new int[80000];
        for(int i=0;i<80000;i++) {
            arr[i]=(int)(Math.random()*80000);
        }
        long start=System.currentTimeMillis();
        select(arr);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void select(int[] arr) {

        for(int i=0;i<arr.length-1;i++) {
            int minIndex=i;
            int min=arr[i];
            for(int j=i+1;j<arr.length;j++) {
                if (min > arr[j]) {
                    minIndex=j;
                    min=arr[j];
                }
            }
            //交换
            if(minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
        }
       // System.out.println(Arrays.toString(arr));
    }
}
