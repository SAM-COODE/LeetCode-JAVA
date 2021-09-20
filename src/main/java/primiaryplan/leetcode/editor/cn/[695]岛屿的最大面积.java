package primiaryplan.leetcode.editor.cn;//给定一个包含了一些 0 和 1 的非空二维数组 grid 。
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。) 
//
// 
//
// 示例 1: 
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// 
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// [[0,0,0,0,0,0,0,0]] 
//
// 对于上面这个给定的矩阵, 返回 0。 
//
// 
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 558 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int col = grid[0].length,row = grid.length;
        //深度优先
        //记录遍历过的位置
        //记录最大
        int result = 0;
        for(int i = 0;i<row;++i){
            for(int j = 0;j<col;++j){
                if(grid[i][j]==1){
                    result = Math.max(countAreaOfIsland(grid,i,j), result);
                }
            }
        }
        return result;
    }
    public int countAreaOfIsland(int[][]grid,int i,int j){
        int result = 0;
        int col = grid[0].length,row = grid.length;
        if(i<0||i>=row||j<0||j>=col){
            return result;
        }
        if(grid[i][j]==1){
            grid[i][j]=0;
            result=1;
            result +=countAreaOfIsland(grid,i-1,j);
            result +=countAreaOfIsland(grid,i+1,j);
            result +=countAreaOfIsland(grid,i,j-1);
            result +=countAreaOfIsland(grid,i,j+1);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
