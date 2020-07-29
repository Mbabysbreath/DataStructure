package pr;

import java.util.HashMap;
import java.util.Map;

/**
 * 里氏替换
 * @author zhaomin
 * @date 2020/7/29 11:11
 */
class Father{
    public void test(HashMap hashMap){
        System.out.println("父类方法--");
    }
}
class Son extends Father{
    //@Override
    public void test(Map map){
        System.out.println("子类方法--");
    }

}
public class Test1 {
    public static void main(String[] args) {
        HashMap map=new HashMap();
//        Father father=new Father();
//        father.test(map);
        Son son=new Son();
        son.test(map);
    }
}
