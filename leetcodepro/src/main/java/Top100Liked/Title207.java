package Top100Liked;

import java.util.HashMap;
import java.util.LinkedList;


/*
现在你总共有 n 门课需要选，记为 0 到 n-1。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？

示例 1:

输入: 2, [[1,0]]
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
说明:

输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
提示:

这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
拓扑排序也可以通过 BFS 完成。
 */
public class Title207 {


    public static void main(String[] args){
        int[][]pre={{0,1},
                    {0,4},
                    {1,4},
                    {4,3},
                    {3,2},
                    {2,0}};
        Title207 title207=new Title207();
       System.out.println("result is :" +title207.canFinish(5,pre));
    }
   private boolean result=true;
    //我的解法
    //拓扑排序检查是否为无环图
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, LinkedList<Integer>> graph=new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 0; i <prerequisites.length; i++) {
            int[]pair=prerequisites[i];
            if (graph.containsKey(pair[0])) graph.get(pair[0]).add(pair[1]);
            else {
                LinkedList<Integer> list=new LinkedList<Integer>();
                list.add(pair[1]);
                graph.put(pair[0],list);
            }
        }
      //  graph.entrySet().stream().sorted();
        for (int i = 0; i <numCourses ; i++) {
            if (!graph.containsKey(i)) graph.put(i,null);
        }
        //DFS 进行拓扑排序,0代表正在被访问，1代表访问结束
        HashMap<Integer,Integer> visited=new HashMap<>();
        for (int i = 0; i <numCourses ; i++) {
            if (!visited.containsKey(i)) visit(graph,visited,i);
        }

        return result;

    }
    public void visit(HashMap<Integer, LinkedList<Integer>> graph,HashMap<Integer,Integer> visited,int start){
        if (!visited.containsKey(start)) {
            visited.put(start, 0);
            if (graph.get(start)!=null) {
                for (int c : graph.get(start)) {
                    if (!visited.containsKey(c)) {
                        visit(graph, visited, c);
                    } else {
                        if (visited.get(c) == 0) {
                            result = false;
                            break;
                        }
                    }
                }

            }
            visited.put(start, 1);
        }

    }
}
