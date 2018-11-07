package Top100Liked;
/*
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 */
public class Title105 {
    public static void main(String[] args){
        Title105 t=new Title105();
        TreeNode  treeNode=t.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
System.out.println(treeNode.val);

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(0,preorder.length-1,preorder,0,inorder.length-1,inorder);
    }
    public TreeNode build(int prestart,int preend,int[] preorder,int instart,int inend,int[] inorder){
        if (prestart>preend||instart>inend) return null;
        TreeNode root=new TreeNode(preorder[prestart]);
        int mid=instart;
        for (int i = instart; i <=inend ; i++) {
            if (inorder[i]==preorder[prestart]) mid=i;
        }
        int len=mid-instart;
        root.left=build(prestart+1,prestart+len,preorder,instart,mid-1,inorder);
        root.right=build(prestart+len+1,preend,preorder,mid+1,inend,inorder);
        return root;
    }
}
