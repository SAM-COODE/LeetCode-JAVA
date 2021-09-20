package primiaryplan.leetcode.editor.cn;
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6063 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        /**
         * 使用数组下标替代hashMap
         * 太牛了太牛了,妈个鸡
         */
        int[] last = new int[128];
        int n = s.length();
        int res = 0;
        int start = 0; // 窗口开始位置
        //不断移动窗口右边界
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            //移动窗口左边界至字符上次出现的位置后一位
            start = Math.max(start, last[index]);
            res   = Math.max(res, i - start + 1);
            last[index] = i+1;
        }

        return res;
    }
    public int foolLengthOfLongestSubstring(String s) {
        //暴力解法:从1开始,找到下一个相同元素,记录最长长度,如此重复,直到n = length-当前最长长度. 复杂度:O(n^2)
        //分析问题: 直到n >= length-当前最长长度
        if(s.length()==0){
            return 0;
        }
        int leftIndex = 0;
        int rightIndex =1;
        int result = 1;
        int tempResult =1;
        Set<Character> words = new HashSet<>();
        words.add(s.charAt(0));
        while(leftIndex<s.length()-result){
            while(rightIndex<s.length()&&!words.contains(s.charAt(rightIndex))){
                words.add(s.charAt(rightIndex));
                ++rightIndex;
                ++tempResult;
            }
            result = Math.max(result, tempResult);
            //左指针移动至第一个rightIndex
            while(rightIndex<s.length()&&s.charAt(rightIndex)!=s.charAt(leftIndex)){
                words.remove(s.charAt(leftIndex));
                ++leftIndex;
                --tempResult;
            }
            ++leftIndex;
            ++rightIndex;
        }
        return result;
    }

    /**
     * 理解错题意了,打扰了
     * @param s
     * @return
     */
    public int wrongLengthOfLongestSubstring(String s) {
        //暴力解法:从长度1开始,一次次查找0-n之间是否有相同字符,复杂度:O(n^2)
        //暴力解法2:从1开始,慢慢增加长度,如果新进入的字符,在串中不存在,则长度加一,重复,直到末尾或新进入的字符在串中存在
        //非暴力:滑动窗口,窗口->固定大小,滑动->逐步增大/减小或移动,
        if(s.length()==0){
            return 0;
        }
        int leftIndex = 0;
        int rightIndex = 1;
        int result = 1;
        while(rightIndex<s.length()){
            char newChar = s.charAt(rightIndex);
            while(leftIndex<rightIndex){
                if(s.charAt(leftIndex)==newChar){
                    return result;
                }
                ++leftIndex;
            }
            leftIndex = 0;
            ++rightIndex;
            ++result;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
