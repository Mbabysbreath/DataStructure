package merge;

import java.util.Arrays;

/**
 * @author zhaomin
 * @date 2020/4/22 10:27
 */
public class MergeTest {
    public static void main(String[] args) {
        int[] arr={8,4,5,7,1,3,6,2,3,4,5,1,0,-1};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    //分+合
    public static void mergeSort(int[] arr,int left,int right){
        if(left<right){
            int mid=left+(right-left)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }
//合并

    /**
     *
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始化索引
     * @param mid 中间索引
     * @param right 右边索引
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int i=left;
        int j=mid+1;
        int t=0;
        int[] temp=new int[arr.length];
        //把左右两边的数据按规则填充到temp数组
        //直到左右两边有序序列有一边处理完毕
        while (i<=mid&&j<=right){
            if(arr[i]<=arr[j]){
                temp[t]=arr[i];
                t+=1;
                i+=1;
            }else{
                temp[t]=arr[j];
                t+=1;
                j+=1;
            }
        }
        //把剩余数据依次全部填充到temp
        while(i<=mid){
            temp[t++]=arr[i++];
        }
        while(j<=right){
            temp[t++]=arr[j++];
        }
        //拷贝temp到原数组arr
        t=0;
        int tempLeft=left;
        while(tempLeft<=right){
            arr[tempLeft++]=temp[t++];
        }
    }
}
