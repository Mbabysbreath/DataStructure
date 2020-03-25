package stack02;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author zhaomin
 * @date 2020/3/22 20:00
 */
public class PolandNotation {
    public static void main(String[] args) {
        String suffuxExpression = "30 4 + 5 * 6 -";
        List<String> listString = getListString(suffuxExpression);
        int calcute = calcute(listString);
        System.out.println("计算的结果："+calcute);

    }

    //将一个逆波兰表达式，依次将数据和运算符 放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list= Arrays.asList(split);
        return list;
    }

    //完成对逆波兰表达式的运算
    public static int calcute(List<String> ls) {
        Stack<String> stack =new Stack<>();
        for (String item : ls) {
            if(item.matches("\\d+")){
                stack.push(item);
            }else{
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res=0;
                if (item.equals("+")) {
                    res = num2 + num1;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }

}
