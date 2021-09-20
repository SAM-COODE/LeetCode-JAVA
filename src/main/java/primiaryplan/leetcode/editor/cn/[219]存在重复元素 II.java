package primiaryplan.leetcode.editor.cn;
//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表 滑动窗口 👍 309 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0, len = nums.length; i < len; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
    public boolean foolContainsNearbyDuplicate(int[] nums, int k) {
        //变长的滑动窗口
        //移动至k,值存到hash表,左边界右滑,比较至
        int leftIndex = 0,rightIndex =0;
        Set<Integer> hash = new HashSet<>(k);
        while(rightIndex<nums.length){
            while (rightIndex-leftIndex<=k&&rightIndex<nums.length) {
                if (hash.contains(nums[rightIndex])) {
                    return true;
                }
                hash.add(nums[rightIndex]);
                ++rightIndex;
            }
            hash.remove(nums[leftIndex]);
            ++leftIndex;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
