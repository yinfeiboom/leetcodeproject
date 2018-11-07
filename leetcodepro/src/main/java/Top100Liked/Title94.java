package Top100Liked;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

 */
public class Title94 {

    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l=new ArrayList<>();
        get(root,l);
        return l;
    }
    public void get(TreeNode root,List<Integer> list){
        if (root==null) return ;
        else {
            get(root.left,list);
            list.add(root.val);
            get(root.right,list);
        }

    }

    //迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        do {
            //依次将左节点均加入栈中
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        } while(!stack.isEmpty() || root != null);
        return result;

    }
}
