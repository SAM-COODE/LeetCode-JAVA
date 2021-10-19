package primiaryplan.leetcode.editor.cn;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1255 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //这不就是最早出现和最后出现的结合版
        //虽然我已经忘了
        int[] result = new int[2];
        int start = 0;
        int length = nums.length;
        int end = length-1;
        int firstMiddle =-1;
        int middle =0;
        while(start<=end){
            middle = start-(start/2-end/2);
            if(nums[middle]<target){
                start=middle+1;
            }else {
                if(nums[middle]==target&&firstMiddle==-1){
                    firstMiddle = middle;
                }
                end = middle-1;
            }
        }
        if(firstMiddle==-1){
            return new int[]{-1,-1};
        }
        result[0] = middle;
        start = firstMiddle;
        end = length-1;
        while(start<=end){
            middle = start-(start/2-end/2);
            if(nums[middle]>target){
                end=middle-1;
            }else {
                start = middle+1;
            }
        }
        result[1] = nums[middle]==target?middle:middle-1;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
