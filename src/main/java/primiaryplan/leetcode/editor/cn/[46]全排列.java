package primiaryplan.leetcode.editor.cn;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1586 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        //全排列
        int length =  nums.length;
        int depth = 0;
        List<List<Integer>> pathList = new ArrayList<>();
        boolean[] used =new boolean[length];
        List<Integer> path = new ArrayList<>();
        dfs(nums,pathList,used,depth,path);
        return pathList;
    }

    private void dfs(int[] nums, List<List<Integer>> pathList, boolean[] used, int depth, List<Integer> path) {
        if(depth==nums.length){
            pathList.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i<nums.length;++i){
            if(!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,pathList,used,depth+1,path);
                used[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
