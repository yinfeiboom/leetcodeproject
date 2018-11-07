package Top100Liked;
/*
给定一个二叉树，原地将它展开为链表。

例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */
public class Title114 {
    public void flatten(TreeNode root) {
        if (root==null) return;
        flatten(root.left);
        if (root.left!=null) {
            TreeNode r1=root.right;
            root.right=root.left;
            root.left=null;
            TreeNode r2=root.right;
            while (r2.right!=null) r2=r2.right;
            r2.right=r1;
        }
    }
}
