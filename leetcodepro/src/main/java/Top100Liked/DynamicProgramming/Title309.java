package Top100Liked.DynamicProgramming;
/*
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]


动态规划：

思路：一道有点诡异的动态规划．因为存在冷却时间

１．在第i天买一支股票还能剩下的利润＝第(i-2)天销售能够剩余的利润－第i天股票的价钱．

２．在第i天卖一支股票总的利润＝第(i-1)天买股票剩下的最大利润＋当前股票的价格．

也就是说需要维护两个状态的信息，一个是买股票所得到的剩余最大利润，一个是卖出股票之后得到的最大利润，他们互相依赖对方的信息．

再来进一步分析如何维持一个最大的利润．

对于买来说，当天是否买取决于买了之后是否比之前买所剩余的利润大，即状态转移方程为：

buy[i] = max(buy[i-1], sell[i-2] - prices[i-1]);

对于卖来说，同样当天是否将这只股票卖掉取决于卖掉能否获得更大的利润，状态转移方程为：

sell[i] = max(sell[i-1], sell[i-1] + prices[i-1]);
---------------------

原文：https://blog.csdn.net/qq508618087/article/details/51671504

 */
public class Title309 {
    public int maxProfit(int[] prices) {
        if(prices.length ==0) return 0;
        int[] buy=new int[prices.length+1];
        int[] sell=new int[prices.length+1];
        buy[1] = -prices[0];
        for (int i = 2; i <=prices.length ; i++) {
            buy[i]=Math.max(buy[i-1],sell[i-2]-prices[i-1]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i-1]);
        }
        return sell[prices.length];
    }
}
