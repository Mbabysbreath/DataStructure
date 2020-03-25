package stack01;

/**
 * @author zhaomin
 * @date 2020/3/22 11:25
 */
public class ArrayStackDemo {
}
class ArrayStack{
    int maxSize;
    int top=-1;
    int[] stack;

    public ArrayStack (int maxSize){
        this.maxSize=maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull(){
       return top==maxSize-1;
    }

    public boolean isEmpty(){
       return top==-1;
    }
    public void push(int num){
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top]=num;
    }

    public int pop(){
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int val = stack[top];
        top--;
        return val;
    }

    public void list(){
        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }
        while (top != -1) {
            System.out.println(stack[top]);
            top--;
        }
    }
}