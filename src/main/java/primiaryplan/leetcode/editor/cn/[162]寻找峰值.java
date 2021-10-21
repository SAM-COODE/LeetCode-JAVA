package primiaryplan.leetcode.editor.cn;
//峰值元素是指其值严格大于左右相邻值的元素。
//
// 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。 
//
// 你可以假设 nums[-1] = nums[n] = -∞ 。 
//
// 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：2
//解释：3 是峰值元素，你的函数应该返回其索引 2。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,1,3,5,6,4]
//输出：1 或 5 
//解释：你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 对于所有有效的 i 都有 nums[i] != nums[i + 1] 
// 
// Related Topics 数组 二分查找 👍 628 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution162 {
    public int findPeakElement(int[] nums) {
        //峰值元素定义,大于左侧,大于右侧
        //可以发现峰值左右两侧都是升序排列的
        //又与上一题类似了
        //middle>right?峰值就在右侧:左侧
        int length = nums.length;
        int start =0;
        int end = length-1;
        int middle =0;
        while(start<=end){
            middle = start-(start-end)/2;
            if(middle==0&&middle==length-1){
                return middle;
            }
            if(middle==0&&nums[middle]>nums[middle+1]){
                return middle;
            }
            if(middle==length-1&&nums[middle]>nums[middle-1]){
                return middle;
            }
            if((nums[middle]>nums[middle+1]&&nums[middle]>nums[middle-1])){
                return middle;
            }
            if(nums[middle]<nums[middle+1]){
                start = middle+1;
            }else {
                end = middle-1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
