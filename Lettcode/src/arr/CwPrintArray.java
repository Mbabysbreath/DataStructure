package arr;

/**
 * @author zhaomin
 * @date 2020/9/28 17:03
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CwPrintArray {
    /**
     * 设置四个边界，当超过边界时就跳出循环，结束
     * @param matrix
     * @return
     */
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return new int[0];
        }
        int top=0;int bot=matrix.length-1;
        int left=0;int right=matrix[0].length-1;
        int[] res=new int[matrix.length*matrix[0].length];
        for(int t=0;t<res.length;){
            for(int i=left;i<=right;i++){
                res[t++]=matrix[top][i];
            }
            if(++top>bot) break;
            for(int i=top;i<=bot;i++){
                res[t++]=matrix[i][right];
            }
            if(--right<left)break;
            for(int i=right;i>=left;i--){
                res[t++]=matrix[bot][i];
            }
            if(--bot<top) break;
            for(int i=bot;i>=top;i--){
                res[t++]=matrix[i][left];
            }
            if(++left>right)break;
        }
        return res;
    }
}
