package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhaomin
 * @date 2020/3/23 10:04
 */
public class InfixToSuffix {

    public static void main(String[] args) {
        String str="1+((2+3)*4)-5";
        List<String> strings = toInfixExpressionList(str);
        System.out.println(strings);

        List<String> list = parseSuffixExpression(strings);
        System.out.println(list);
    }

    //将中缀表达式改为后缀表达式
    public static List<String> parseSuffixExpression(List<String> list) {
         Stack<String> stack=new Stack<>();
         List<String> arrayList=new ArrayList<>();
         //1.如果是数字，就入中间结果栈（list）
        for (String item : list) {
            if(item.matches("\\d+")){
                arrayList.add(item);
            }else{
                //符号入符号栈
                //(1-遇到运算符，比较与栈顶运算符的优先级：
                //a-如果s1为空，或栈顶运算符为左括号（---直接入栈
                if (item.equals("(") ) {
                    stack.push(item);
                }else if (item.equals(")")) {
                    //如果为）,依次弹出s1的符号，并压入s2,直到遇到左括号为止，
                    // 此时将一对括号丢弃
                    while (!stack.peek().equals("(")) {
                        arrayList.add(stack.pop());
                    }
                    stack.pop();
                }else{
                    //如果优先级比栈顶高，压入栈
                    //否则，将s1的运算符弹出并压入到s2
                    while (stack.size() != 0 && operPriority(stack.peek()) >= operPriority(item)) {
                        arrayList.add(stack.pop());
                    }
                    stack.push(item);
                }
            }
        }
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    //比较运算符的优先级
    public static int operPriority(String oper){
         int ADD=1;
         int DEL=1;
         int MUL=2;
         int DEV=2;
         int res=0;
        switch (oper) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = DEL;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DEV;
                break;
                default:
                    System.out.println("符号不正确");
                    break;
        }
        return res;
    }

    //将中缀表达式转为list存储--字符串操作起来不方便--考虑多位数
    public static List<String> toInfixExpressionList(String s) {
        List<String> list=new ArrayList<>();
        int index=0;
        char ch;
        String str;//多位数
        do {
            ch=s.charAt(index);
            if(ch<'0'||ch>'9'){
                list.add(ch+"");
                index++;
            }else if(ch>='0'&&ch<='9'){
                str="";
                while (index < s.length() && (ch=s.charAt(index)) >= '0' && (ch=s.charAt(index)) <= '9') {
                    str+=ch;
                    index++;
                }
                list.add(str);
            }
        } while (index < s.length());
        return list;
    }
}
