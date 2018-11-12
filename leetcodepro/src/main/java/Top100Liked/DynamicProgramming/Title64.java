package Top100Liked.DynamicProgramming;
/*
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class Title64 {

    public static void main(String[] args){
        Title64 title64=new Title64();
        int[][] grid={{1,2},
                      {1,1}};
        System.out.println(title64.minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
        int[][]dp=new int[grid.length][grid[0].length];
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if (i==0&&j==0){
                    dp[0][0]=grid[0][0];
                }
                else if (i==0) {
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                }
                else if (j==0){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }
               else dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }






        return dp[grid.length-1][grid[0].length-1];
    }
    public int get(int m,int n,int[][] grid){
        int sum=0;
        if (m==0){
            for (int i = 0; i <=n ; i++) {
                sum+=grid[m][i];
            }
            return sum;
        }
        if (n==0){
            for (int i = 0; i <=m ; i++) {
                sum+=grid[i][n];
            }
            return sum;
        }
        return Math.min(get(m-1,n,grid),get(m,n-1,grid))+grid[m][n];
    }
}
