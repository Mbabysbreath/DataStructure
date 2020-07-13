package linkedList;

import java.util.List;

/**
 * @author zhaomin
 * @date 2020/7/13 14:19
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
}

public class ReverseLinkedList {
    public ListNode reverseListNode(ListNode head){
        if(head==null){
            return head;
        }
        ListNode newList=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=newList;
            newList=cur;
            cur=next;
        }
        return newList;
    }


}
