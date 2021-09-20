package primiaryplan.leetcode.editor.cn;
//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 双指针 字符串 👍 326 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution557 {
    public String reverseWords(String s) {
        int wordStartIndex = 0;
        int scanIndex = 0;
        int wordEndIndex = 0;
        char[] chars = new char[s.length()];
        s.getChars(0,s.length(),chars,0);
        while(scanIndex<=s.length()){
            if(scanIndex==s.length()||s.charAt(scanIndex)==' ') {
                wordEndIndex = scanIndex - 1;
                reverseString(chars, wordStartIndex, wordEndIndex);
                wordStartIndex = scanIndex + 1;
                if(scanIndex!=s.length()){
                    chars[scanIndex] = ' ';
                }
            }
            ++scanIndex;
        }
        return new String(chars);
    }
    public void reverseString(char[] s,int startIndex,int endIndex) {
        while(startIndex<endIndex){
            s[startIndex] = (char) (s[endIndex]^s[startIndex]);
            s[endIndex] = (char) (s[startIndex]^s[endIndex]);
            s[startIndex] = (char) (s[startIndex]^s[endIndex]);
            ++startIndex;
            --endIndex;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
