package Top100;

import entity.ListNode;
import org.junit.Test;

import java.util.*;

public class No24 {

    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        while(temp != null){
            ListNode a = temp;
            ListNode b = temp.next;
            if(a!=null&&b!=null){
                if(b.next!=null){
                    a.next = b.next;
                }else{
                    a.next = null;
                }
                b.next = a;
            }
            temp = temp.next;
            if(temp == null){
                break;
            }
        }
        return head.next;
    }


    @Test
    public void test(){
        //head = [1,2,3,4]
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(swapPairs(a));

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode node : lists) {
            ListNode temp = node;
            while(temp!=null){
                list.add(temp.val);
                temp = temp.next;
            }
        }
        Collections.sort(list);
        if(list.size()==0){
            return null;
        }
        ListNode result = new ListNode(list.get(0));
        ListNode current = result;
        for (int i = 1; i < list.size(); i++) {
            ListNode temp = new ListNode(list.get(i));
            current.next = temp;
            current = temp;
        }
        return result;
    }

    @Test
    public void test2(){
        String x =   "";
        System.out.println(x.trim());
    }

    /**
     * 链表节点翻转
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        List<ListNode> list = new ArrayList<>();
        while(temp!=null){
            list.add(temp);
            temp = temp.next;
        }
        if(list.size()<k){
            return head;
        }
        ListNode end = null;
        int index = 0;
        while(index < list.size()){
            int j = index + k;
            int d = k - 1;
            if( j < list.size()){
                while(d>0){
                    list.get(index+d).next = list.get(index+d-1);
                    d--;
                }
                if( end != null){
                    end.next = list.get(j-1);
                }
                end = list.get(index);
            }else{
                if( end != null){
                    end.next = list.get(index+1);
                }
            }
            index = index + k;
        }
        return list.get(k-1);
    }


    /**
     * No31
     * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     *
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     *
     * 必须 原地 修改，只允许使用额外常数空间。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        //靠右较小的数，和靠左较大的数
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }


    public void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void reverse(int[] nums,int start){
        int end = nums.length -1;
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    @Test
    public void test4(){
        int[] nums = {1,3,2};
        nextPermutation(nums);

    }


    /**
     * No 32
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public int calculate(String s, int index) {
        int end = s.length() -1;
        while(index<end){
          if(isOK(s.substring(index,end+1))){
              return end - index + 1;
          }else{
              end --;
          }
        }
        return 0;
    }

    public boolean isOK(String s){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.push("(");
            }else if(s.charAt(i)==')'&&!stack.isEmpty()&&stack.peek()=="("){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }


    /**
     * NO33
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     *
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     *
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return -1;
        }
        if(n==1){
            return nums[0] == target ? 0:-1;
        }
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[0] <= nums[mid]){//左侧有序
                if(nums[0] <= target && target < nums[mid]){
                    right  = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else{
                //右侧有序
                if(nums[mid]<target&&target<=nums[n-1]){
                    left = mid + 1;
                }else{
                    right = mid -1;
                }
            }
        }
        return -1;
    }


    /**
     * No 34
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if(nums.length == 1 || target<nums[0]|| target>nums[nums.length-1]){
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if(target == nums[i]){
                if(result[0] == -1){
                    result[0] = i;
                }else{
                    result[1] = i;
                }
            }
            if(nums[i]>target){
                break;
            }
        }
        if(result[0]!=-1&&result[1]==-1){
            result[1] = result[0];
        }
        return result;
    }

    /**
     * No36
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     *
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,List<Character>> box = new HashMap<>(9);
        Map<Integer,List<Character>> row = new HashMap<>(9);
        Map<Integer,List<Character>> column = new HashMap<>(9);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.'){
                    continue;
                }
                if(!putChar(box,j / 3 + (i / 3) * 3,board[i][j])){
                    return false;
                }
                if(!putChar(row,i,board[i][j])){
                    return false;
                }
                if(!putChar(column,j,board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean putChar( Map<Integer,List<Character>> map,int index,char board){
        List<Character> characters = map.get(index);
        if(characters!=null){
            if(characters.contains(board)){
                return false;
            }else{
                characters.add(board);
            }
        }else{
            ArrayList<Character> list = new ArrayList<>();
            list.add(board);
            map.put(index,list);
        }
        return true;
    }



    @Test
    public void test7(){
        char[][] x =
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
        System.out.println(1 << 2);
    }

}
