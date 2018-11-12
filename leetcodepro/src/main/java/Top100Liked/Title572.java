package Top100Liked;
/*
给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

示例 1:
给定的树 s:

     3
    / \
   4   5
  / \
 1   2
给定的树 t：

   4
  / \
 1   2
返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 */
public class Title572 {
    //todo https://leetcode.com/problems/subtree-of-another-tree/
    public static void main(String[] args){
        Title572 t =new Title572();
        TreeNode s1=new TreeNode(1);
        TreeNode s2=new TreeNode(1);
        TreeNode s3=new TreeNode(1);
        s1.right=s2;
        t.isSubtree(s1,s3);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null&&t!=null) return false;
        if (s!=null&&t==null) return false;
        if (s==null&&t==null) return true;
        boolean res=false;
        if (s.val==t.val){//比较左右子树
            boolean l=isSubtree(s.left,t.left);
            boolean r=isSubtree(s.right,t.right);
            res= l&&r;
        }
        if(!res) {//t与s的左右子树比较

            boolean l=isSubtree(s.left,t);
            boolean r=isSubtree(s.right,t);
            res= l||r;
        }
        return res;
    }
}
