import java.io.PrintWriter;

/**
 * @author zhaomin
 * @date 2020/3/19 20:55
 * 1.将二维的棋盘数组---》稀疏数组---》存到文件中
 * 0--无  1--黑子  2--蓝子
 *2.反向操作
 */
public class SparseArr {
    public static void main(String[] args) {
        //1.原始棋盘11*11,并输出
        int[][] chess=new int[11][11];
        chess[0][2]=1;
        chess[1][3]=2;
        chess[3][4]=2;
        for(int[] row:chess) {
            for(int col:row){
                System.out.printf("%d\t",col);
            }
            System.out.println();
        }
        //2.创建稀疏数组，读取原始棋盘的非0数值的个数
        int sum=0;
        for (int[] row : chess) {
            for(int col:row){
                if(col!=0){
                    sum++;
                }
            }
        }
        int[][] sparseArr=new int[sum+1][3];
        sparseArr[0][0]=chess.length;
        sparseArr[0][1]=chess[0].length;
        sparseArr[0][2]=sum;
        System.out.println();
        //3.将棋盘数组中的非零数值写到稀疏数组中,并输出稀疏数组
        int count=0;
        for(int i=0;i<11;i++) {
            for(int j=0;j<11;j++) {
                if(chess[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chess[i][j];
                }
            }
        }

        for(int i=0;i<sum+1;i++) {
            for(int j=0;j<3;j++){
                System.out.printf("%d\t",sparseArr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        //4.从稀疏数组中读取数据转为原始的棋盘数据
        int[][] chessArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i=0;i<chessArr.length;i++) {
            for(int j=0;j<chessArr[0].length;j++) {
                System.out.printf("%d\t",chessArr[i][j]);
            }
            System.out.println();
        }
        //5.依次读取稀疏数组的每一行数据，并添加到棋盘对应位置
        for(int i=1;i<sparseArr.length;i++) {
               chessArr[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        System.out.println();
        //3.输出棋盘
        for(int i=0;i<chessArr[0].length;i++) {
            for(int j=0;j<chessArr.length;j++) {
                System.out.printf("%d\t",chessArr[i][j]);
            }
            System.out.println();
        }

    }
}
