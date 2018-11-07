package Top100Liked;
/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
 */

import java.util.ArrayList;
import java.util.List;

public class Title98 {

    List<Integer> list=new ArrayList<>();
    public static void main(String[] args){
        Title98 title98=new Title98();
        TreeNode treeNode1=new TreeNode(2);
        TreeNode treeNode2=new TreeNode(1);
        TreeNode treeNode3=new TreeNode(3);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        title98.isValidBST(treeNode1);
        System.out.println(title98.list);

    }
    public boolean isValidBST(TreeNode root) {
        get(root);
        boolean res=true;
        for (int i = 0; i <list.size()-1 ; i++) {
            if (list.get(i)>list.get(i+1)) res=false;
        }
        return res;
    }
    public void get(TreeNode root){
    if (root==null) return ;
    get(root.left);
    int v=root.val;
    list.add(v);
    get(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
