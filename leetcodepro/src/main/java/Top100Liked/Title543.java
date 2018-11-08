package Top100Liked;

import java.util.ArrayList;
import java.util.List;

/*
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
这条路径可能穿过根结点。
示例 :
给定二叉树

          1
         / \
        2   3
       / \
      4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class Title543 {
    List<Integer> list=new ArrayList<>();
    int max=0;
    public static void main(String[] args){
        Title543 t=new Title543();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        t1.left=t2;
        t2.left=t4;
//        t2.right=t5;
        t4.left=t5;
        t1.right=t3;
      System.out.println("res: "+t.diameterOfBinaryTree(t1));
      t.list.stream().forEach(System.out::println);

    }

    public int diameterOfBinaryTree(TreeNode root) {
            TreeNode p=root;
             DFS(root);
//             if (list.isEmpty()) return 0;
//             else return list.stream().max((o1,o2)->o1.compareTo(o2)).get();
        return max;
    }
    public int DFS(TreeNode root){
        TreeNode p=root;
        if (p!=null){

            int left=DFS(p.left);
            int right=DFS(p.right);
            if (max<(left+right)) max=left+right;
            //list.add(" root "+p.val+" sum is :"+sum);
            return 1+Math.max(left,right);
        }
        else {
            return 0;
        }
    }
}
