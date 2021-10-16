package primiaryplan.leetcode.editor.cn;
//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 字符串 回溯 👍 311 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> ans = new ArrayList();
        ans.add(new StringBuilder());

        for (char c: s.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; ++i)
                    ans.get(i).append(c);
            }
        }

        List<String> finalans = new ArrayList();
        for (StringBuilder sb: ans)
            finalans.add(sb.toString());
        return finalans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
//干,读错题了
    /*
    *private void dfs(String s, List<String> result, StringBuilder stringBuilder, boolean[] used, int depth) {
    if(depth==s.length()){
        result.add(stringBuilder.toString());
        return;
    }
    for(int i = 0;i<s.length();++i){
        if(!used[i]){
            char c = s.charAt(i);
            used[i]=true;
            if('a'<c&&c<'z'){
                stringBuilder.append(s.charAt(i));
                dfs(s,result,stringBuilder,used,depth+1);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                stringBuilder.append(Character.toUpperCase(s.charAt(i)));
                dfs(s,result,stringBuilder,used,depth+1);
            }else if('A'<c&&c<'Z'){
                stringBuilder.append(s.charAt(i));
                dfs(s,result,stringBuilder,used,depth+1);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                stringBuilder.append(Character.toLowerCase(s.charAt(i)));
                dfs(s,result,stringBuilder,used,depth+1);
            }else {
                stringBuilder.append(s.charAt(i));
                dfs(s,result,stringBuilder,used,depth+1);
            }
            used[i]=false;
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    } */

