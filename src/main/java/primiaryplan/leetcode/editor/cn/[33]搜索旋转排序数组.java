package primiaryplan.leetcode.editor.cn;
//整数数组 nums 按升序排列，数组中的值 互不相同 。
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 👍 1628 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
    public int NotTooFoolSearch(int[] nums, int target) {
        //首先找出旋转点的位置,再判断属于哪一个分组进行二分查找
        //共两次二分
        int length = nums.length;
        int point  = binarySearchPoint(nums,0,length-1);
        point = (point+1>=length)?point:(nums[point+1]>nums[point]?point:point+1);
        if(nums[length-1]>=target){
            return binarySearch(nums,target,point,length-1);
        }else {
            return binarySearch(nums,target,0,point-1);
        }
    }
    public int binarySearch(int[] nums,int target,int start,int end){
        int middle;
        while(start<=end){
            middle = start-(start-end)/2;
            if(nums[middle]==target){
                return middle;
            }
            if((nums[middle]<target)){
                start = middle+1;
            }else {
                end = middle-1;
            }
        }
        return -1;
    }
    public int binarySearchPoint(int[] nums,int start,int end){
        int middle=0;
        int target = nums[end];
        while(start<=end){
            middle = start-(start-end)/2;
            if((nums[middle]>target)){
                start = middle+1;
            }else {
                end = middle-1;
            }
        }
        return middle;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
