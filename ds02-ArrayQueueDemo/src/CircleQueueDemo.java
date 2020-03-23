import java.util.Scanner;

/**
 * @author zhaomin
 * @date 2020/3/20 13:40
 */
public class CircleQueueDemo {
    public static void main(String[] args) {
        System.out.println("测试环形队列的案例~~~");
        CircleQueue queue=new CircleQueue(4);//这里设置4，队列有效数据最多为3
        char key=' ';
        boolean loop=true;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("a(add)入队");
            System.out.println("d(delete)出队");
            System.out.println("s(display)打印队列");
            System.out.println("h(head)打印队头");
            System.out.println("e(exit)退出");
            System.out.println("-----请选择-----");
            key=scanner.next().charAt(0);//接受一个字符
            switch (key) {
                case 'a':
                    System.out.println("请输入元素：");
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
class CircleQueue{
    private int[] arr;
    private int maxSize;//表示数组的最大容量
    private int front;
    private int rear;

    public CircleQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
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
        return (rear+1)%maxSize==front;
    }

    /**
     * 入队--添加插入元素
     */
    public void add(int element) {
        if(isFull()){//判断是否为满
            System.out.println("队列已满，插入元素失败");
            return;
        }
        arr[rear]=element;
        rear=(rear+1)%maxSize;
    }
    /**
     * 出队--删除队列元素
     */
    public int delete(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空，删除元素失败");
        }
       int val=arr[front];
       front=(front+1)%maxSize;
        return val;
    }
    /**
     * 打印队列中的所有元素
     * 思路：从front开始遍历，遍历多少个元素
     */
    public void display(){
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        //因为front不一定是从0开始的
        for(int i=front;i<front+size();i++){
            System.out.printf("a[%d]=%d ",i%maxSize,arr[i%maxSize]);
        }
    }
    /**
     * 计算队列实际元素
     */
    private int size(){
        return (maxSize-front+rear)%maxSize;
    }
    /**
     * 获取队列的第一个元素
     */
    public int head(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法获取头元素");
        }
        return arr[front];
    }
}