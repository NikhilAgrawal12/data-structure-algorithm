package BinaryTrees;

public class ContructFromInorderPostorder5 {
    class Solution {

        int preIdx=0;

        private TreeNode build(int[] preorder, int[] inorder, int start, int end){

            if(start>end){
                return null;
            }

            TreeNode root = new TreeNode(preorder[preIdx]);
            preIdx++;

            int inIdx=start;

            while(inorder[inIdx]!=root.val){
                inIdx++;
            }

            root.left=build(preorder,inorder,start,inIdx-1);
            root.right=build(preorder,inorder,inIdx+1,end);

            return root;


        }


        public TreeNode buildTree(int[] preorder, int[] inorder) {

            return build(preorder,inorder,0,inorder.length-1);

        }
    }
}
