package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTrees2 {

    public static class Node{

        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static class BinaryTree{
        static int idx = -1;

        Node buildTree(int[] nodes){
            idx++;

            if(nodes[idx]==-1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);

            newNode.left= buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;


        }

    }

    public static void preorder(Node root){

        if(root==null){
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){

        if(root==null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }


    public static void postorder(Node root){

        if(root==null){
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelorder(Node root){
        Queue<Node> q = new LinkedList<>();

        if(root==null){
            return;
        }

        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node newNode = q.remove();

            if(newNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(newNode.data + " ");
                if(newNode.left!=null){
                    q.add(newNode.left);
                }
                if(newNode.right!=null){
                    q.add(newNode.right);
                }

            }
        }
    }

    public static int countNodes(Node root){

        if(root==null){
            return 0;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static int sumNodes(Node root){

        if(root==null){
            return 0;
        }

        return sumNodes(root.left) + sumNodes(root.right) + root.data;
    }

    public static int height(Node root){

        if(root==null){
            return 0;
        }


        return Math.max(height(root.left),height(root.right))+1;
    }

    public static int diameter(Node root){

        if(root==null){
            return 0;
        }

        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right)+ 1;

        return Math.max(diam3, Math.max(diam1,diam2));

    }



    public static void main(String[] args){
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);

        System.out.println("\nPreorder:");
        preorder(root);

        System.out.println("\nInorder:");
        inorder(root);

        System.out.println("\nPostorder:");
        postorder(root);

        System.out.println("\nLevelorder:");
        levelorder(root);


        int count= countNodes(root);
        System.out.println("\nNo of Nodes: " + count);

        int s= sumNodes(root);
        System.out.println("\nSum of Nodes: " + s);

        int h= height(root);
        System.out.println("\nHeight of Tree: " + h);

        int d= diameter(root);
        System.out.println("\nDiameter of Tree: " + d);


    }
}
