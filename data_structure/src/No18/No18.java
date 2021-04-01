package No18;

import entity.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 */
public class No18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int size = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        if(size<4){
            return list;
        }
        Arrays.sort(nums);
        int a,b,c,d;
        for (a = 0; a < size -3; a++) {
            if(a>0&&nums[a] == nums[a-1]){
                continue;
            }
            for (b = a +1; b < size -2; b++){
                if(b > a + 1 && nums[b] == nums[b -1]){
                    continue;
                }
                c = b +1;
                d = size -1;
                while (c < d){
                    if(nums[a] + nums[b] + nums[c] + nums[d]<target){
                        c++;
                    }else if(nums[a] + nums[b] + nums[c] + nums[d]>target){
                        d--;
                    }else{
                        List<Integer> temp = new ArrayList<>(4);
                        temp.add(nums[a]);
                        temp.add(nums[b]);
                        temp.add(nums[c]);
                        temp.add(nums[d]);
                        list.add(temp);
                        while(c<d&&nums[c] == nums[c+1]){
                            c++;
                        }
                        while(c<d&&nums[d] == nums[d-1]){
                            d--;
                        }
                        c++;
                        d--;
                    }
                }
            }
        }
        return list;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            list.add(temp);
            temp = temp.next;
        }
        int size = list.size();
        if(n<=0||n> size){
            return head;
        }
        if(size == n){  //处理删除第一个
            return head.next;
        }
        if(n == 1){  //处理删除最后一个
            ListNode listNode = list.get(size - 2);
            listNode.next = null;
            return head;
        }
        ListNode listNode = list.get(size - n - 1 );
        ListNode listNode1 = list.get(size - n + 1);
        listNode.next = listNode1;
        return head;
    }

    @Test
    public void test(){
//        int[] nums = {1,0,-1,0,-2,2};
        int[] nums = {0,0,0,0};
        int target = 0;
        System.out.println(fourSum(nums,target));
    }

    @Test
    public void test2(){
        //head = [1,2,3,4,5], n = 2
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(removeNthFromEnd(node,2));
    }


}
