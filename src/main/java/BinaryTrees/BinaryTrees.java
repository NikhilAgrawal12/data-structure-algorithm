package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTrees {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree{
        static int idx = -1;

        Node buildTree(int[] nodes){
            idx++;

            if(nodes[idx]==-1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;
        }

    }

    static void preorder(Node root){

        if(root==null){
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void inorder(Node root){

        if(root==null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void postorder(Node root){
        if(root==null){
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    static void levelorder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){

            Node newNode=q.remove();

            if(newNode==null){
                System.out.println();

                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }
            else{
                System.out.print(newNode.data+ " ");
                if(newNode.left!=null){
                    q.add(newNode.left);
                }
                if(newNode.right!=null){
                    q.add(newNode.right);
                }
            }
        }

    }

    static int countNodes(Node root){

        if(root==null){
            return 0;
        }

        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);

        return leftNodes + rightNodes +1;

    }

    static int sumNodes(Node root){

        if(root==null){
            return 0;
        }

        int leftSum=sumNodes(root.left);
        int rightSum=sumNodes(root.right);

        return leftSum+rightSum+root.data;
    }

    static int height(Node root){

        if(root==null){
            return 0;
        }

        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        return Math.max(leftHeight,rightHeight) +1;
    }




    public static void main(String[] args){

        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        System.out.println(root.data);

        System.out.println("Preorder: ");
        preorder(root);

        System.out.print("\n \n");
        System.out.println("Inorder: ");
        inorder(root);

        System.out.print("\n \n");
        System.out.println("Postorder: ");
        postorder(root);

        System.out.print("\n \n");
        System.out.println("Levelorder: ");
        levelorder(root);

        int count = countNodes(root);

        System.out.println("\nTotal Nodes: "+count);

        System.out.println("\nSum of Nodes: "+ sumNodes(root));

        System.out.println("\nHeight of Tree: "+ height(root));

    }


}
