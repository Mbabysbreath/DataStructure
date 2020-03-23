import java.util.Scanner;

/**
 * 数组模拟单向队列
 * @author zhaomin
 * @date 2020/3/20 0:12
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue=new ArrayQueue(3);
        char key=' ';
        boolean loop=true;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("a(add)入队");
            System.out.println("d(delete)出队");
            System.out.println("s(display)打印队列");
            System.out.println("h(head)打印队头");
            System.out.println("e(exit)退出");
            System.out.println("----请选择----");
            key=scanner.next().charAt(0);//接受一个字符
            switch (key) {
                case 'a':
                    System.out.println("输入元素：");
                    int elememt=scanner.nextInt();
                    queue.add(elememt);
                    break;
                case 'd':
                    int delete = 0;
                    try {
                        delete = queue.delete();
                        System.out.println("删除元素："+delete);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 's':
                    System.out.println("队列元素：");
                    queue.display();
                    System.out.println();
                    break;
                case 'h':
                    try {
                        int res=queue.head();
                        System.out.println("队头元素："+res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    System.out.println("程序退出");
                    break;
                default:
                        break;
            }
        }
    }
}
class ArrayQueue{
    private int maxSize;//表示队列的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//队列的底层实现数组，模拟队列

    /**
     * 构造器
     * @param maxSize
     */
    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        front=-1;//指向队头，front指向队列头的前一个位置
        rear=-1;//队尾最后一个数据（front,rear]
    }
    /**
     * 判断队列释是否为空
     */
    public boolean isEmpty(){
        return front==rear;
    }
    /**
     * 判断队列是否为满
     */
    public boolean isFull(){
        return rear==maxSize-1;
    }

    /**
     * 入队--添加插入元素
     */
    public void add(int element) {
        if(isFull()){//判断是否为满
            System.out.println("队列已满，插入元素失败");
            return;
        }
        rear++;
        arr[rear]=element;
    }
    /**
     * 出队--删除队列元素
     */
    public int delete(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空，删除元素失败");
        }
        front++;
        return arr[front];
    }
    /**
     * 打印队列中的所有元素
     */
    public void display(){
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for(int i=front+1;i<=rear;i++) {
            System.out.print(arr[i]+" ");
        }
    }
    /**
     * 获取队列的第一个元素
     */
    public int head(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法获取头元素");
        }
        return arr[front+1];
    }
}

