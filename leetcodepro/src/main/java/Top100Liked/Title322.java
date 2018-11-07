package Top100Liked;

import java.util.Arrays;

/*
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1

说明:
你可以认为每种硬币的数量是无限的。
 */
public class Title322 {
    public static void main(String[] args){
        Title322 title322=new Title322();
        int[] coins=new int[]{2};
        System.out.println(title322.coinChange(coins,3));
    }

    public int min = Integer.MAX_VALUE;
    public int coinChange2(int[] coins, int amount) {
        helper(coins, amount, coins.length-1, 0);
        return min==Integer.MAX_VALUE?-1:min;
    }
    public void helper(int[] coins, int amount, int i, int count)
    {
        if(i<0||amount<0) return;
        if(amount==0) min = Math.min(min, count);
        helper(coins, amount-coins[i], i, count+1);
        helper(coins, amount, i-1, count);
    }





    public int coinChange(int[] coins, int amount) {
        //todo 本题目未搞懂、
        // 假设我取了一个值为5的硬币，那么由于目标值是11，所以是不是假如我们知道dp[6]，那么就知道了组成11的dp值了？所以我们更新dp[i]的方法就是遍历每个硬币，
        // 如果遍历到的硬币值小于i值（比如我们不能用值为5的硬币去更新dp[3]）时，我们用 dp[i - coins[j]] + 1 来更新dp[i]，
        // 动态规划-------dp[i] = min(dp[i], dp[i - coins[j]] + 1);
        int[] dp=new int[amount+1];
        dp[0]=0;
        for (int i = 1; i <dp.length ; i++) {
            dp[i]=amount*2;
        }
        for (int i = 1; i <amount+1 ; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i-coins[j]>=0)
                    dp[i]=Math.min(dp[i],dp[i - coins[j]] + 1);

            }
        }
        return (dp[amount]>amount)? -1:dp[amount];

    }

}
