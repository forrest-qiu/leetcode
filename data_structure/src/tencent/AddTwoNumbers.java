package tencent;

import org.junit.Test;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int j = 0;
        ListNode result = null;
        ListNode index = null;
        while(l1 != null || l2 != null){
            int x = (l1 != null) ? l1.val:0;
            int y = (l2 != null ) ? l2.val:0;
            int sum = x + y + j;
            if(result == null){
                result = new ListNode(sum%10);
                index = result;
            }else{
                index.next = new ListNode(sum%10);
                index = index.next;
            }
            j = sum/10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if(j != 0){
            index.next = new ListNode(j);
        }
        return result;
    }



    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

     @Test
     public void fun(){
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//         ListNode l2 = new ListNode(5);
//         l2.next = new ListNode(6);
//         l2.next.next = new ListNode(4);
         ListNode l1 = new ListNode(5);
         l1.next = new ListNode(7);
         l1.next  = new ListNode(9);
//         ListNode l2 = null;
         ListNode l2 = new ListNode(5);
          l2.next = new ListNode(5);
         ListNode listNode = addTwoNumbers(l1, l2);
         while (listNode!=null){
             System.out.print(listNode.val+"\t>\t");
             listNode  = listNode.next;
         }

     }

}
