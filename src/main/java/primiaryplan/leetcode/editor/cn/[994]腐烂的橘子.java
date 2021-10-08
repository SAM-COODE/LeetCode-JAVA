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
class Solution {
    public Queue<Map<Integer,Integer>> queue =new ArrayDeque<>();
    public int orangesRotting(int[][] grid) {
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
            进阶:本质是图的问题,既然是图,则有 无向图/有向图以及边的权重问题
         */
        //本质上是一个求最短路径的问题,找到所有的新鲜橘子位置,不太对哦
        //加个辅助数据结构来记录新鲜橘子腐烂的分钟数?每次更新成更小的那一个?
        //问题就来了,何时结束?没有节点被更新?-1为不会腐烂
        //腐烂是有顺序的,按顺序更新?
        //复杂度?
        //十八个队列的列表
        //先找到所有新鲜橘子?
        //从找到的第一个新鲜橘子开始,找不到则直接返回0;
        //好像也不用,找到离自己最近的腐烂橘子就可以了
        List<Queue<Map<Integer,Integer>>> list = new ArrayList<>();
        int maxCol = grid.length,maxRow = grid[0].length;
        int[][] mark = new int[maxCol][maxRow];
        int result =-1;
        markAllFreshOrange(grid,list,mark);
        refreshMark(list,grid);
        return result;
    }

    private void refreshMark(List<Queue<Map<Integer, Integer>>> list, int[][] grid) {

    }

    private void markAllFreshOrange(int[][] grid,List<Queue<Map<Integer,Integer>>> list,int[][] mark) {
        int maxCol = grid.length,maxRow = grid[0].length;
        for(int col =0;col<maxCol;++col){
            for(int row = 0;row<maxRow;++row){
                if(grid[col][row]==1){
                    findFirstRottedOrange(grid,col,row);
                }
            }
        }
    }
    private void findFirstRottedOrange(int[][]grid,int col,int row){
        int maxCol = grid.length,maxRow = grid[0].length;
        int result = 0;
        //广度优先
        //辅助队列
        Map<Integer,Integer> map = new HashMap<>(1);
        map.put(col,row);
        queue.add(map);
        //循环
        while(!queue.isEmpty()){
            Map<Integer,Integer> tempMap = queue.poll();
            int key =tempMap.keySet().iterator().next();
            if(key<0||key>maxCol||row<0||row>maxRow){
                return;
            }
            //广度
            //终止点
            if(grid[key][tempMap.get(key)]==1){
                Map<Integer,Integer> newMap = new HashMap<>(1);
            }
            if(grid[col][row]==2){
                break;
            }
            //每层加1
            ++result;
        }
        return ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
