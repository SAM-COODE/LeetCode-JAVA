package primiaryplan.leetcode.editor.cn;
//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 👍 719 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
 class Solution {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        //漏了场景很烦,已经很接近了
        //转换成了选或不选的问题
        //使用中间数组来记录已选的数字
        //当中间数组等于k时为正确组合
        //当中间数组小于边界时直接返回
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }

    public List<List<Integer>> foolCombine(int n, int k) {
        //注意,组合,非排列,用一个少一个
        //当已经知道解题方式为递归时,如何快速找出题解?
        //递归的要素:
            //边界
            //递推公式
        //边界算是比较好找的,我们先来找下边界
            //一般来说,我们从最小/少的情况开始试验
            //对本题来说,写出几个我们会发现,一个数的新增组合,只会是与比他自己大的数的组合
            //边界值为start = n-k+1,k =1
        //递推公式为
        //f(start,n,k) = f(start+1,n,k-1)
        List<List<Integer>> result = new ArrayList<>();
        if(k==1){
            int start = 1;
            while(start<=n){
                List<Integer> singleList = new ArrayList<>(1);
                singleList.add(start);
                result.add(singleList);
                ++start;
            }
            return result;
        }
        int start = 1;
        while(start<=n-k+1){
            result.addAll(combine(start,n,k));
            ++start;
        }
        return result;
    }
    public List<List<Integer>> combine(int start,int n, int k ){
        List<List<Integer>> result = new ArrayList<>();
        if(k==1){
            while(start<=n){
                List<Integer> singleList = new ArrayList<>(1);
                singleList.add(start);
                result.add(singleList);
                ++start;
            }
            return result;
        }
        result = combine(start+1,n,k-1);
        for(List<Integer> numberList:result){
            numberList.add(start);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
