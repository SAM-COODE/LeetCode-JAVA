package primiaryplan.leetcode.editor.cn;//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 双指针 👍 732 👎 0


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
class Solution {

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public static ListNode deleteDuplicates(ListNode head) {
        //如果是数组直接遍历即可,单向链表需要将所有相同节点全部删除的话,因为不能回退,需要双指针
        //双指针,起点相同,移动右节点直至不同,如果有相同节点,则删除左节点后将左节点移动至右节点相同位置
        if(head==null){
            return head;
        }
        ListNode newHead = new ListNode(0,head);
        ListNode leftLast = newHead;
        ListNode left = head;
        ListNode right = head.next;
        boolean isSame = false;
        while(right!=null){
            if(right.val==left.val){
                isSame = true;
                deleteListNode(right,left);
            } else if(isSame){
                isSame = false;
                leftLast.next = right;
                left = right;
            }else{
                leftLast = left;
                left = right;
            }
            right = right.next;
        }
        if(isSame){
            leftLast.next = right;
        }
        return newHead.next;
    }
    public static void deleteListNode(ListNode listNode,ListNode lastNode){
         lastNode.next = listNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
