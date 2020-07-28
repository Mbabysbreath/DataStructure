import java.util.Scanner;

/**
 * @author zhaomin
 * @date 2020/7/28 9:46
 */
public class Solution {
    public static String largestNumber(int[] nums) {
        if(nums==null||nums.length==0){
            return new String();
        }
        for(int i=0;i<nums.length-1;i++){
            boolean flag=false;
            String res="";
            for(int j=0;j<nums.length-1-i;j++){
                String s1=res+nums[j]+nums[j+1];
                String s2=res+nums[j+1]+nums[j];
                if(s1.compareTo(s2)<0){
                    int tem=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tem;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int num:nums){
            sb.append(num);
        }
        if(sb.charAt(0)=='0') return "0";
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String[] arr=str.split(",");
        int[] nums=new int[arr.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.valueOf((arr[i]));
        }

        System.out.println(largestNumber(nums));
    }
}
