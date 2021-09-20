package primiaryplan.leetcode.editor.cn;
//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 433 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution567 {
    public  boolean checkInclusion(String s1, String s2) {
        /**
         * 很烦,忽略了可以转换为固定长度的滑动窗口
         */
        //既然滑动窗口的长度是固定的,则可以改变下,左/右边界的移动方式
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
    public  boolean foolCheckInclusion(String s1, String s2) {
        //看到题的瞬间我就已经傻了..
        //暴力解法:穷举所有排列,一一看s2,中是否包含,复杂度: 爆炸 O(n!)
        //分析:包含所有排列意味着,子串包含且仅包含所有s1的字符,数量也相同
        //既然已经提示是滑动窗口了,右边界不断向右移动,不断移除匹配上的字符,直到在哈希表中找不到值,或者哈希表被清空(结果)
            //如果,是重复出现但数量不一致,则左边界移动至第一次出现位置后一位,否则左右同时=右边界+1,重复上述步骤,直至到达末尾

        // 记录 数量 s1 可能包含重复字符


        int[] hash = new int[128];
        int[] originalHash = new int[128];
        //记录字符第一次出现位置
        int[] indexHash = new int[128];
        //需要匹配的总数量
        int sum = 0;
        //遍历S1
        for(int i = 0;i<s1.length();++i){
            hash[s1.charAt(i)]+=1;
            originalHash[s1.charAt(i)]+=1;
            ++sum;
        }
        int leftIndex =0;
        int rightIndex = 0;
        //滑动窗口终止条件:左边界至逻辑末尾
        while (leftIndex<=(s2.length()-s1.length())){
            //滑动窗口右边界终止条件:遇到第一个不符合的元素
            while(rightIndex<s2.length()&&hash[s2.charAt(rightIndex)]!=0){
                hash[s2.charAt(rightIndex)]-=1;
                if(hash[s2.charAt(rightIndex)]==0) {
                    //总数减一的位置
                    indexHash[s2.charAt(rightIndex)] = rightIndex + 1;
                }
                --sum;
                ++rightIndex;
            }
            if(sum==0){
                return true;
            }
            //如何移动左边界
            //这里有问题,有多次重复的扫描,尝试将左边界移动至,总数减一的位置
            if(indexHash[s2.charAt(rightIndex)]!=0){
                leftIndex = indexHash[s2.charAt(rightIndex)];
                rightIndex = leftIndex;
            }else {
                leftIndex = rightIndex+1;
                rightIndex = leftIndex;
            }
            //计数器归位
            for(int resetIndex = 'a';resetIndex<'z';++resetIndex){
                sum +=(originalHash[resetIndex]-hash[resetIndex]);
                hash[resetIndex] = originalHash[resetIndex];
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
