package test;

import java.util.Stack;

/**
 * @author zhaomin
 * @date 2020/3/21 18:26
 */
public class Test {
    public static void main(String[] args) {
        Test obj=new Test();
        Node head=new Node(0,0);
        Node n1 = new Node(1, 1);
        Node n2 = new Node(2, 2);
        Node n3 = new Node(3, 3);
        Node head1=new Node(0,0);
        Node n4 = new Node(1, 1);
        Node n5 = new Node(5, 2);
        Node n6 = new Node(6, 3);
        head.next=n1;n1.next=n2;n2.next=n3;
        head1.next=n4;n4.next=n5;n5.next=n6;
        int length = obj.getLength(head);
        System.out.println(length);

        System.out.println("合并有序链表：");
        Node merge = obj.merge(head1,head);
        obj.show(merge);
        System.out.println("-------end--------");
        Node lastIndexNode = obj.findLastIndexNode(head, 3);
        System.out.println(lastIndexNode);
        System.out.println("---反转---");
        Node reverse = obj.reverse(head);
        obj.show(reverse);
        System.out.println("逆序打印：");
        obj.reverseLinked(reverse);

    }
    /**
     * 1.获取单链表的节点的个数（如果是带头结点的，不算）
     */
    public int getLength(Node head) {
        Node temp=head.next;
        if (head.next == null) {
            return 0;
        }
        int length=0;
        while (temp != null) {
            length++;
            temp=temp.next;
        }
        return length;
    }

    /**
     * 2.寻找链表中倒数第K个节点
     */
    public Node findLastIndexNode(Node head,int index) {
        //1.先遍历链表找到一共有多少节点
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        //2.从头开始找链表的第size-index个
        Node temp=head.next;
        for(int i=0;i<size-index;i++) {
            temp=temp.next;
        }
        return temp;
    }

    /**
     * 3.反转单链表:删除+插入--破坏了原有的数据结构
     * 1、先创建一个节点reverNode
     * 2.遍历原来的节点，取出每个节点node,并删除
     * 3.reverNode.next=node
     * 4.最后让原来的头结点head.next=reversNode.next;
     */
    public Node reverse(Node head) {
        if(head.next==null){
            return null;
        }
        Node reverNode=new Node(0,0);
        Node temp=head.next;
        while (temp != null) {
            head.next=temp.next;
            temp.next=reverNode.next;
            reverNode.next=temp;
            temp=head.next;
        }
        head.next=reverNode.next;
        return head;
    }

    /**
     * 4.逆序遍历链表，不能破坏原有数据结构
     * 用栈解决
     */
    public void reverseLinked(Node head) {
        if (head.next == null) {
            return;
        }
        Node temp=head.next;
        Stack<Node> stack=new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp=temp.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并两个有序链表为一个有序链表
     *
     * @return
     */
    public Node merge(Node head1, Node head2) {
        Node temp1=head1;
        Node temp2=head2.next;

        while (temp1.next != null &&  temp2 != null) {
            if (temp1.next.value <= temp2.value) {
                temp1=temp1.next;
            }else{
                Node next=temp2.next;
                temp2.next=temp1.next;
                temp1.next=temp2;
                temp2=next;
            }
        }
        if (temp1.next== null) {
            temp1.next=temp2;
        }
        return head1;

    }
    public void show(Node head){
        Node temp=head.next;
        while (temp != null) {
            System.out.println(temp);
            temp=temp.next;
        }
    }
}
