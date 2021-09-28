package primiaryplan.leetcode.editor.cn;
//给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
//
// 如果存在一个整数 x 使得 n == 2ˣ ，则认为 n 是 2 的幂次方。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：true
//解释：2⁰ = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 16
//输出：true
//解释：2⁴ = 16
// 
//
// 示例 3： 
//
// 
//输入：n = 3
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：n = 4
//输出：true
// 
//
// 示例 5： 
//
// 
//输入：n = 5
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能够不使用循环/递归解决此问题吗？ 
// Related Topics 位运算 递归 数学 👍 409 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution231 {
    public boolean isPowerOfTwo(int n) {
        //2次幂 ,则只有最高位为1,则n-1除最高位外都为1,则相与==0
        return n > 0 && (n & (n - 1)) == 0;
    }
    public boolean loopIsPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        while(n>0){
            if(n==1){
                return true;
            }
            int i =n%2;
            if(i>0){
                return false;
            }
            n = n/2;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
