package primiaryplan.leetcode.editor.cn;
//在给定的网格中，每个单元格可以有以下三个值之一：
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。 
//
// 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。 
//
// 
//
// 示例 1： 
//
//
//
// 输入：[[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 输入：[[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 输入：[[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 10 
// 1 <= grid[0].length <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 424 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution994 {
    private static Queue<int[]> queue =new ArrayDeque<>();
    private static int[][] searched;
    private static List<int[]> robots = new ArrayList<>();
    static {
        robots.add(new int[]{1,0});
        robots.add(new int[]{-1,0});
        robots.add(new int[]{0,1});
        robots.add(new int[]{0,-1});
    }
    public int orangesRotting(int[][] grid) {
        int result = 0;
        /*
        广度优先
        中午吃太多了,先整理下深度优先和广度优先的总体思路再写吧
        什么是广度优先
            假设有四个盒子,每个盒子里还有小盒子,现在告诉你某一个盒子(可能是外层盒子)里放了一只赛博坦星球的猴子,请你找到他
            如果你拆完所有大盒子再来拆小盒子,这就是广度优先
        什么是深度优先
            如果你拆完一个大盒子以及他里面的所有小盒子,再来拆另一个大盒子,这就是深度优先
        两者的区别以及应用场景
            这两种算法在最开始被发明时,其实是为了解决什么桥问题来的?
            适用深度优先的问题
                特点:
                    1.需要遍历所有节点
                    2.节点无状态,或节点状态不会改变
                通用解法:
                    递归
            适用广度优先的问题
                特点:
                    1.可能无须遍历所有节点
                    2.需要重复遍历某些节点
                    3.节点状态可能改变
                通用解法:
                    队列
                    //模板:入队,出队,如果需要计算层数,则需要计算每层入队数量,即每层加入的新元素数量
            进阶:本质是图的问题,既然是图,则有 无向图/有向图以及边的权重问题
         */
        //本质上是一个求最短路径的问题,找到所有的新鲜橘子位置,不太对哦
        //定义一个无敌源点,则所有腐烂橘子到无敌源点的位置距离为1,则,首先将所有腐烂的橘子入队,依次广度,
        //直到所有节点都被找到过一次,或腐烂橘子周围没有新鲜橘子
        //最后查找是否还有新鲜橘子,以及最大分钟数;
        int maxCol = grid.length;
        int maxRow = grid[0].length;
        searched = new int[maxCol][maxRow];
        //所有腐烂橘子入队
        for(int col =0;col<maxCol;++col){
            for(int row=0;row<maxRow;++row){
                if(grid[col][row]==2) {
                    queue.offer(new int[]{col, row});
                    searched[col][row] = 1;
                }
            }
        }
        //广度优先
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int tempCol = temp[0];
            int tempRow = temp[1];
            for(int[] robot:robots){
                int drivedCol = tempCol+robot[0];
                int drivedRow = tempRow+robot[1];
                if(drivedCol<0||drivedCol>=maxCol||drivedRow<0||drivedRow>=maxRow||searched[drivedCol][drivedRow]>0||grid[drivedCol][drivedRow]==0){
                    continue;
                }
                searched[drivedCol][drivedRow]=searched[tempCol][tempRow]+1;
                queue.offer(new int[]{drivedCol,drivedRow});
            }
        }
        //确定结果
        for(int col =0;col<maxCol;++col){
            for(int row=0;row<maxRow;++row){
                if(searched[col][row]==0&&grid[col][row]!=0){
                    return -1;
                }
                result = Math.max(searched[col][row]-1,result);
            }
        }
        return  result;
    }

    //todo 动态规划

}
//leetcode submit region end(Prohibit modification and deletion)
