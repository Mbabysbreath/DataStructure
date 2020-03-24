package linkedlist;

/**
 * @author zhaomin
 * @date 2020/3/21 21:36
 */
class LinkedNode{
    int val;
    LinkedNode next;
    LinkedNode pre;
    public LinkedNode(){

    }
    public LinkedNode(int val){
        this.val=val;
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "val=" + val +
                '}';
    }
}
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        LinkedNode n1=new LinkedNode(1);
        LinkedNode n2=new LinkedNode(2);
        LinkedNode n3=new LinkedNode(3);

        DoubleLinkedList linkedList=new DoubleLinkedList();
        linkedList.add(n1);
        linkedList.add(n2);
        linkedList.add(n3);
        System.out.println("打印链表：");
        linkedList.show();
        System.out.println("更新链表--");
        linkedList.update(new LinkedNode(1), 11);
        linkedList.show();
        System.out.println("删除链表节点");
        linkedList.delete(2);
        linkedList.show();
        linkedList.delete(2);
        linkedList.update(new LinkedNode(2),22);
        System.out.println("===================");
        linkedList.addByOrder(new LinkedNode(14));
        linkedList.show();
        System.out.println("==============");
        linkedList.addByOrder(new LinkedNode(13));
        linkedList.show();
        System.out.println("====================");
        linkedList.addByOrder(new LinkedNode(6));
        linkedList.show();
    }
}

class DoubleLinkedList{
    LinkedNode head=new LinkedNode();

    /**
     * 返回头结点
     */
    public LinkedNode getHead(){
        return head;
    }
    /**
     * add插入---尾插
     */
    public void add(LinkedNode node) {
        LinkedNode temp=head;
        while (temp.next != null) {
            temp=temp.next;
        }
        temp.next=node;
        node.pre=temp;
    }

    /**
     * 删除delete
     */
    public void delete(int val) {
        if (head.next == null) {
            System.out.println("链表为空，删除失败");
            return;
        }
        LinkedNode temp=head.next;
        while (temp.val != val) {
            temp=temp.next;
            if (temp == null) {
                System.out.println("没有要删除的节点");
                return;
            }

        }
        temp.pre.next=temp.next;
        if(temp.next!=null) {
            temp.next.pre = temp.pre;
        }
    }
    /**
     * update 更新
     */
    public void update(LinkedNode node,int val){
        if (head.next == null) {
            System.out.println("链表为空，不能修改");
            return;

        }
        LinkedNode temp=head.next;

        while (temp.val != node.val) {

            temp=temp.next;
            if (temp == null) {
                System.out.println("没有要修改的节点");
                return ;
            }
        }
        temp.val=val;
    }

    /**
     * 按顺序添加；
     */

    public void addByOrder(LinkedNode node) {
        LinkedNode temp=head;
        boolean flag=false;
        while (true) {
            if (temp.next == null) {
                break;
            }else if (temp.next.val > node.val) {
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag) {
            temp.next.pre=node;
            node.next=temp.next;
            temp.next=node;
        }else{
           temp.next=node;
        }
    }
    /**
     * 遍历
     */
    public void show(){
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        LinkedNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp=temp.next;
        }
    }
}