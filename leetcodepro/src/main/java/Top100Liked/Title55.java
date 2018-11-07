package Top100Liked;
/*
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class Title55 {
    public static void main(String[] args){
        Title55 r=new Title55();
        int[] nums=new int[]{3,2,1,0,4};
        System.out.println(r.canJump(nums));
    }
    public boolean canJump(int[] nums) {
        boolean[] dp=new boolean[nums.length];
        int n=nums.length-1;
        dp[0]=true;
        for (int j = 0; j <=n ; j++) {
            for (int i = 0; i <j; i++) {
                if (j<=i+nums[i]&&dp[i]==true) dp[j]=true;
            }
        }
        return dp[nums.length-1];

    }
}
