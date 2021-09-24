package primiaryplan.leetcode.editor.cn;
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 1982 👎 0


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
class Solution206 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        //数组由于支持随机读取,可以使用双指针
        //解题思路还是有问题,题目没有标签完全想不到用递归
        //暴力解法:一次次的走到最后一个节点 n^2
        //也不是想不到 哈哈
        ListNode nextNode = head.next;
        ListNode now = head;
        head.next = null;
        while(true){
            ListNode tempNextNode = nextNode.next;
            nextNode.next = now;
            now = nextNode;
            if(tempNextNode==null){
                return nextNode;
            }
            nextNode = tempNextNode;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
