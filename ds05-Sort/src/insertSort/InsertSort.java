package insertSort;

import java.util.Arrays;

/**
 * @author zhaomin
 * @date 2020/3/26 22:26
 */
public class InsertSort {
    public static void main(String[] args) {

        int[] arr=new int[80000];
        for(int i=0;i<80000;i++) {
            arr[i]=(int)(Math.random()*80000);
        }
        long start = System.currentTimeMillis();
        insert(arr);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void insert(int[] arr) {
        int insertVal=0;
        int insertIndex=0;
        for(int i=1;i<arr.length;i++) {
            insertVal=arr[i];
            insertIndex=i-1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            /*赋值语句和判断语句那个时间复杂度高*/
            if(insertIndex+1!=i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
      //  System.out.println(Arrays.toString(arr));
    }
}
