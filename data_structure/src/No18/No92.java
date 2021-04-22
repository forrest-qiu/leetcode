package No18;

import entity.ListNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 *
 */
public class No92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 1;
        ListNode a = head;
        ListNode a_last = null;   //第1段链表最后一个元素
        ListNode b_first = null;  //第2段链表第一个元素
        ListNode b_last = null;   //第2段链表最后一个元素
        ListNode c_first = null;  //第3段第一个元素
        Deque<ListNode> stack = new ArrayDeque<>();
        while(head!=null){
            if(i == left-1){
                a_last = head;  //找到a段链表的最后一个元素
            }else if(left <= i && i <= right){
                stack.push(head);
            }else{
                if(i == right+1){
                    c_first = head;
                    break;
                }
            }
            ++i;
            head = head.next;
        }
        if(!stack.isEmpty()){
            b_first = stack.peek();
        }
        while(!stack.isEmpty()){
            b_last = stack.pop();
            if(b_last!=null){
                b_last.next =  stack.peek();
            }
        }
        if(a_last!=null){
            a_last.next = b_first;
        }
        if(b_last!=null){
            b_last.next = c_first;
        }
        return left == 1 ?b_first:a;
    }

    @Test
    public void fun(){
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        t1.next = t2;
        t2.next = t3;
        System.out.println(reverseBetween(t1,1,1));
    }

}
