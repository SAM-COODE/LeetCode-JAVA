package primiaryplan.leetcode.editor.cn;
//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 508 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution542 {
    static Queue<int[]> queue = new ArrayDeque<>();
    static int maxCol,maxRow;
    static int[][] searchedArray;
    static List<int[]> robot = new ArrayList<>();
    static {
        robot.add(new int[]{0,1});
        robot.add(new int[]{0,-1});
        robot.add(new int[]{1,0});
        robot.add(new int[]{-1,0});
    }
    public int[][] updateMatrix(int[][] mat){
        maxCol = mat.length;
        maxRow = mat[0].length;
        searchedArray = new int[maxCol][maxRow];
        //放置所有0;
        for(int col=0;col<maxCol;++col){
            for(int row= 0;row<maxRow;++row){
                if(mat[col][row]==0){
                    queue.offer(new int[]{col,row});
                    searchedArray[col][row]=1;
                }
            }
        }
        //广度优先
        markOne(mat);
        return mat;
    }
    private void markOne(int[][] mat){
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int col = pos[0];
            int row = pos[1];
            for(int[] posRobot:robot){
                int drivedCol = col+posRobot[0];
                int drivedRow = row+posRobot[1];
                if(drivedCol<0||drivedCol>=maxCol||drivedRow<0||drivedRow>=maxRow||searchedArray[drivedCol][drivedRow]==1){
                    continue;
                }
                mat[drivedCol][drivedRow] = mat[col][row]+1;
                queue.add(new int[]{col+posRobot[0],row+posRobot[1]});
                searchedArray[drivedCol][drivedRow]=1;
            }
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
 /* foolSolution
 给每一个0找1,复杂度O(n^2)
 private int maxCol,maxRow;
    private Queue<int[]> queue = new ArrayDeque<>();
    public int[][] updateMatrix(int[][] mat) {
        //最近的0,明显是求最短路径问题,广度优先
        maxCol = mat.length;
        maxRow = mat[0].length;
        int[][] result = new int[maxCol][maxRow];
        for(int col = 0;col<maxCol;++col){
            for(int row =0;row<maxRow;++row){
                result[col][row] = countPath(mat,col,row);
            }
        }
        return result;
    }

    private int countPath(int[][] mat, int col, int row) {
        int result = -1;
        int[] map =new int[]{col,row};
        queue.offer(map);
        while(!queue.isEmpty()){
            //todo
            int size = queue.size();
            while(size-- >0) {
                int[] tempMap = queue.poll();
                int tempCol = tempMap[0];
                int tempRow = tempMap[1];
                if (tempCol < 0 || tempCol >=maxCol || tempRow < 0 || tempRow >= maxRow) {
                    continue;
                }
                if (mat[tempCol][tempRow] == 1) {
                    int[]  upMap = new int[]{col-1,row};
                    queue.offer(upMap);
                    int[] downMap = new int[]{col+1,row};
                    queue.offer(downMap);
                    int[] leftMap = new int[]{col,row-1};
                    queue.offer(leftMap);
                    int[] rightMap = new int[]{col,row+1};
                    queue.offer(rightMap);
                } else {
                    queue.clear();
                    return result+1;
                }
            }
            ++result;
        }
        return result;
    }

 */
