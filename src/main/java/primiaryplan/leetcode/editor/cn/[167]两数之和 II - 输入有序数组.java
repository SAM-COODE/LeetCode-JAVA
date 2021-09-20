package primiaryplan.leetcode.editor.cn;//给定一个已按照 非递减顺序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
//leetcode submit region begin(Prohibit modification and deletion)
class Solution167{
    public int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left ++;
            } else {
                right --;
            }
        }
        return new int[]{-1, -1};

    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //双指针
        //头递增至<target,尾二分
        //注意 :不可使用相同元素
        //答案有且仅有一对
        int startIndex = 0;
        int endIndex = numbers.length-1;
        //不使用相同元素
        while(startIndex<endIndex){
            int sencondIndex = search(numbers,startIndex+1,endIndex,target-numbers[startIndex]);
            if(sencondIndex!=-1){
                return new int[]{++startIndex,++sencondIndex};
            }
            ++startIndex;
        }
        return new int[2];

    }
    public int search(int[] numbers,int startIndex,int endIndex,int target){
        //大量找不到,先判断头尾元素
        if(numbers[startIndex]>target||numbers[endIndex]<target){
            return -1;
        }
        while(startIndex<=endIndex){
            int middleIndex = endIndex-(endIndex-startIndex)/2;
            if(numbers[middleIndex]==target){
                return middleIndex;
            }
            if(numbers[middleIndex]<target){
                startIndex = middleIndex+1;
            }else if (numbers[middleIndex]>target){
                endIndex = middleIndex-1;
            }
        }
        return -1;
    }
}
 **/

