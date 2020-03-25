package stack01;

/**
 * @author zhaomin
 * @date 2020/3/22 11:42
 */
class Node{
    int val;
    Node next;
    public Node(int val){
        this.val=val;
    }
}
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedListStack listStack=new LinkedListStack(5);
        boolean empty = listStack.isEmpty();
        System.out.println(empty);
        listStack.push(new Node(1));
        listStack.push(new Node(2));
        listStack.push(new Node(3));
        listStack.push(new Node(4));
        listStack.push(new Node(5));
        listStack.push(new Node(6));
      listStack.list();
    }
}
class LinkedListStack{
    private int maxsize;
    private int top=-1;
    private LinkedStack stack=new LinkedStack();

    LinkedListStack(int maxsize) {
        this.maxsize=maxsize;
    }
    public boolean isFull(){
        return top==maxsize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public void push(Node node){
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        stack.add(node);
    }
    public int pop(){
        if (isEmpty()) {
            throw new RuntimeException("栈已空");
        }
        int delete = stack.delete();
        top--;
        return delete;
    }
    public void list(){
        stack.list();
    }
}
class LinkedStack{
    Node head=null;

    public void add(Node node) {
        node.next=head;
        head=node;
    }

    public int delete(){
        int val= head.val;
        head=head.next;
        return val;
    }
    public void list(){
        while (head != null) {
            System.out.println(head.val);
            head=head.next;
        }
    }
}