package linklist;

/**
 * @author zhaomin
 * @date 2020/9/22 22:57
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

 

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main02 {
    /**
     * 原地反转
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if(head==null) return head;
        ListNode cur=head;
        ListNode n1=cur.next;
        ListNode n2=cur.next;
        while(n1!=null){
            if(n1.next!=null){
                n2=n1.next;
                n1.next=cur;
                cur=n1;
                n1=n2;
            }else{
                n1.next=cur;
                head.next=null;
                return n1;
            }
        }
        return head;
    }

    /**
     * 新建一个链表
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head==null) return head;
        ListNode newList=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode node=cur.next;
            cur.next=newList;
            newList=cur;
            cur=node;
        }
        return newList;
    }
}
