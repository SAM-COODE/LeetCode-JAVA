package primiaryplan.leetcode.editor.cn;
//给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：能尝试使用一趟扫描实现吗？ 
//
// 
//
// 注意：本题与主站 19 题相同： https://leetcode-cn.com/problems/remove-nth-node-from-end-
//of-list/ 
// Related Topics 链表 双指针 👍 3 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class SolutionJZ021 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * 使用一个自定义节点作为头结点,无须做 是否删除头结点的复杂判断
         * 使用一个信号量来判断两者之间距离,无须分两次while
         */
        // 先查找倒数第n个节点，然后执行删除操作
        // 使用双指针，两个指针之间的距离为 n-1
        ListNode list = new ListNode(-1);
        list.next = head;
        ListNode left = list;
        ListNode right = list;
        int index = 0;
        while (right != null) {
            // 右指针先移动，如果左右指针相距n，则左指针开始移动，
            // 直到右指针到达表尾，左指针所指即为要删除的节点
            if(index > n) {
                left = left.next;
            }else {
                index++;
            }
            right = right.next;
        }
        left.next = left.next.next;
        return list.next;
    }
    public ListNode foolRemoveNthFromEnd(ListNode head, int n) {
        //暴力解法:遍历一遍,获得长度,再遍历一次删除第N个节点
        //非暴力: 双指针,右侧指针先走N-1次后,二者同时向后走直至右侧走到末尾,删除左侧指针指向的元素
        //返回头节点,两种情况,头节点被删除:null/未被删除:head
        if(head==null){
            return null;
        }
        ListNode preIndex = null;
        ListNode leftIndex = head;
        ListNode rightIndex = head;
        int i =1;
        while(i++<n){
            //题目限制,无须空处理
            rightIndex = rightIndex.next;
        }
        while(rightIndex.next!=null){
            if(preIndex==null){
                preIndex =head;
            }else {
                preIndex = preIndex.next;
            }
            rightIndex = rightIndex.next;
            leftIndex = leftIndex.next;
        }
        if(head==leftIndex){
            return head.next;
        }
        preIndex.next = leftIndex.next;
        return head;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
