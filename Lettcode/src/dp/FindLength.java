package dp;

/**
 * @author zhaomin
 * @date 2020/9/14 16:46
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
示例：

输入：
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出：3
解释：
长度最长的公共子数组是 [3, 2, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLength {
    public static int findLength(int[] A,int[] B){
        int row=A.length+1;
        int col=B.length+1;
        int max=0;
        int[][] dp=new int[row][col];
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=B.length;j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=0;
                }
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
