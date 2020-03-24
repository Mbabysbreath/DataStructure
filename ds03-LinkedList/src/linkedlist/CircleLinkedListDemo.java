package linkedlist;

/**
 * @author zhaomin
 * @date 2020/3/22 9:16
 */
class Lnode{
        int val;
        Lnode next;
        Lnode(){

        }
    Lnode(int val) {
        this.val=val;
    }

    public Lnode getNext() {
        return next;
    }

    public void setNext(Lnode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Lnode{" +
                "val=" + val +
                '}';
    }
}
public class CircleLinkedListDemo {
    public static void main(String[] args) {
        CircleLinked linked=new CircleLinked();
        linked.add(5);
        linked.show();
        System.out.println("===============");
        linked.outCircle(1, 2, 5);
    }
}
//创建一个环形单向链表
class CircleLinked{
    Lnode first = new Lnode();
    Lnode temp=first;
    public void add(int num) {
        if (num < 1) {
            System.out.println("num的值要至少大于1");
            return;
        }

        for(int i=1;i<=num;i++) {
            Lnode boy=new Lnode(i);
            if (i == 1) {
                first=boy;
                first.setNext(first);//构成环
            }
            temp.setNext(boy);
            temp=boy;
            boy.setNext(first);
        }
    }
    public void show(){
        if (first == null) {
            System.out.println("当前链表为空");
            return;
        }
        //使用辅助指针
        temp=first;
        while (temp.getNext()!=first) {
            System.out.println(temp);
            temp=temp.next;
        }
        System.out.println(temp);
    }

    /**
     * 约瑟夫出圈
     * @param startNo 从第几个孩子开始
     * @param count 数几下
     * @param nums 一共有几个孩子
     */
    public void outCircle(int startNo, int count, int nums) {
        if (startNo < 1 || startNo > nums) {
            System.out.println("输入参数不合法");
            return;
        }
        //获取辅助指针指向每个报数的孩子的前一个
        Lnode helper=first;
        while (helper.getNext() != first) {
            helper=helper.getNext();
        }
        //在开始前，让helper和first移动到指定位置
        for(int i=0;i<startNo-1;i++) {
            first=first.getNext();
            helper=helper.getNext();
        }
        while (first != helper) {
            for(int i=0;i<count-1;i++) {
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.println(first+"---->出圈");
            first=first.next;
            helper.next=first;
        }
        System.out.println("最后剩余小孩儿是---》"+first);
    }
}