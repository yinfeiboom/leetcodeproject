package Top100Liked.DynamicProgramming;

import java.util.Arrays;

/*
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].


示例 2:

输入: [1, 2, 3, 5]

输出: false

解释: 数组不能分割成两个元素和相等的子集.
 */
public class Title416 {
    public static void main(String[] args){
        Title416 title416=new Title416();
        System.out.println(title416.canPartition(new int[]{1, 3, 2, 4}));
    }
    /*
    动态规划：
    dp(i,j)表示nums中前i个元素的子集和等于j
    若nums[i] > j，则nums[i]不在子集s中。
    若nums[i] <= j, 则有以下两种情况：一种情况是nums[i]不在子集s中，则subset(i, j) = subset(i-1, j); 一种情况是S[i]在子集s中，则subset(i, j)= subset(i-1, j-S[i]).


     */
    public boolean canPartition_dynamic(int[] nums) {
        if (nums.length==0) return false;
        Arrays.sort(nums);
        int sum=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];

        }
        if (sum%2!=0) return false;
        else {
            int target=sum/2;
            boolean[][] dp = new boolean[nums.length][target + 1];

            if(nums[0] <= target) dp[0][nums[0]] = true;

            for (int i = 0; i <nums.length ; i++) {
                dp[i][0]=true;
            }

            for(int i = 1; i < dp.length; i++) {
                for(int j = 1; j < dp[0].length; j++) {
                    if(j < nums[i]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    }
                }
            }
            return dp[dp.length - 1][dp[0].length - 1];
        }

    }




    public boolean canPartition(int[] nums) {
        if (nums.length==0) return false;
        Arrays.sort(nums);
        int sum=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];

        }
        if (sum%2!=0) return false;
        else {
            int target=sum/2;

            //n 数之和为target
            return helper(nums,target,nums.length-1);


        }

    }
    //递归
    //考虑N个数的数组A中是否存在和为K的解，可以分为考虑（N-1个数中是否有和为K的解）或者（N-1个数中是否有和为K-A[N-1]的解（解包含A[N-1]的情况））。
    public boolean helper(int[] nums,int target,int N){
        if (N==-1) return false;
        if (N==0&&nums[N]==target) return true;

        boolean r1=helper(nums,target-nums[N],N-1);
        if (r1==true)
            return true;
        else
            return helper(nums,target,N-1);

    }
}
