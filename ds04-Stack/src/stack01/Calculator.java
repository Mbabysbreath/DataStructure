package stack01;

/**
 * @author zhaomin
 * @date 2020/3/22 15:26
 */
public class Calculator {
    public static void main(String[] args) {
        String str="120*2+9/3-9";

        ArrayStack1 numStack=new ArrayStack1(10);
        ArrayStack1 operStack=new ArrayStack1(10);
        //定义需要的变量
        int index=0;//用于扫描字符串
        int res=0;
        int num1=0;
        int num2=0;
        int oper=0;
        char ch=' ';//每次扫描得到的char保存到ch

        while (true) {
            ch=str.charAt(index);
            index++;
            if (operStack.isOper(ch)) {
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                }else{
                    if (operStack.operPriorty(ch) <= operStack.operPriorty(operStack.peek())) {
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=operStack.pop();
                        res=numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }
            }else{
                //numStack.push(ch-'0');
                // 处理多位数
                String keepNum="";

                keepNum+=ch;
                while (index!=str.length()&&!numStack.isOper(str.charAt(index))){
                    keepNum+=str.charAt(index);
                    index++;
                }
                numStack.push(Integer.parseInt(keepNum));
            }
            if (index == str.length()) {
                break;
            }
        }

        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }

        int res1=numStack.pop();
        System.out.println(res1);
    }
}
class ArrayStack1{
    int maxsize;
    int top=-1;
    int[] stack;

    public ArrayStack1(int maxsize) {
        this.maxsize=maxsize;
        stack=new int[maxsize];
    }
    public boolean isFull(){
        return top==maxsize-1;
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

    public int peek(){
        return stack[top];
    }

    public void list(){
        if (isEmpty()) {
            System.out.println("栈空。没有数据");
            return;
        }
        for(int i=top;i>=0;i--) {
            System.out.println(stack[i]);
        }
    }

    //确定符号的优先级
    public int operPriorty(int ch) {
        if (ch == '*' || ch == '/') {
            return 1;
        } else if (ch == '+' || ch == '-') {
            return 0;
        }else{
            return -1;
        }
    }

    //判断是否是符号
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算
    public int cal(int num1, int num2, int oper) {
        int res=0;
        switch (oper) {
            case '*':
                res=num1*num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            default:
                break;
        }
        return res;
    }
}