package linkedlist;

/**
 * @author zhaomin
 * @date 2020/3/21 15:10
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Node n1=new Node("aa",1);
        Node n2=new Node("bb",2);
        Node n3=new Node("cc",3);

        SingleLinkedList list=new SingleLinkedList();
//        list.add(n1);
//        list.add(n3);
//        list.add(n2);
            list.addByOrder(n1);
            list.addByOrder(n3);
            list.addByOrder(n2);
        list.show();
        list.update(new Node("ww", 1));
        list.show();
        list.delete(1);
        list.show();
        list.delete(4);
        list.show();
    }
}

class SingleLinkedList {
    //创建一个头结点
    Node head = new Node(" ", 0);

    /**
     * 创建一个add方法,踩过坑
     * public  void add(Node node){//错误写法
     * Node temp=head.next;
     * while(true){
     * if(temp==null){
     * break;
     * }
     * temp=temp.next;
     * }
     * temp=node;
     * }
     */

    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 按顺序添加元素
     */
    public void addByOrder(Node node) {
        Node temp = head;
        boolean flag = false;

        //2.找到了(中间、最后)
        //3.已经有了，就不能添加了 flag
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.age == node.age) {
                flag = true;
                break;
            } else if (temp.next.age > node.age) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("改节点已经存在");
            return;
        } else {
            node.next = temp.next;
            temp.next = node;
        }
        return;
    }

    /**
     * 修改链表的节点,根据age修改
     */
    public void update(Node node) {
        Node temp = head.next;
        if (temp == null) {
            System.out.println("链表为空，无法修改");
            return;
        }
        boolean flag = false;
        while (true) {
            if (temp == null) {//已经遍历完链表了
                break;
            } else if (temp.age == node.age) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
        } else {
            System.out.println("链表中没有要修改的对象");
        }
    }

    /**
     * 显示的方法
     */
    public void show() {
        Node temp = head.next;
        if (temp == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            if (temp == null) {
                return;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 删除链表的节点,按年龄删除
     */
    public void delete(int age) {
        Node temp = head;
        boolean flag=false;
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.age == age) {
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag) {
            temp.next=temp.next.next;
        }else{
            System.out.println("链表中没有要删除的数据");
         }
    }
}
class Node{
    String name;
    int age;
    Node next;
   Node(String name, int age) {
        this.age=age;
        this.name=name;
    }


    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}