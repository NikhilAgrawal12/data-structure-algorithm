package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTrees3 {

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    public static class BinaryTree{

        static int idx = -1;

        Node buildTree(int[] nodes){
            idx++;

            if(nodes[idx]==-1){
                return null;
            }

            Node root = new Node(nodes[idx]);
            root.left=buildTree(nodes);
            root.right=buildTree(nodes);

            return root;
        }
    }

    public static void preorder(Node root){

        if(root==null){
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){

        if(root==null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+ " ");
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

    public static int sumOfNodes(Node root){
        if(root==null){
            return 0;
        }

        return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;

    }

    public static int height(Node root){
        if(root==null){
            return 0;
        }

        return Math.max(height(root.left),height(root.right)) + 1;
    }

    public static int diameter(Node root){

        if(root==null){
            return 0;
        }

        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1;

        return Math.max(diam1, Math.max(diam2,diam3));
    }






    public static void main(String[] args){

        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        System.out.println("Root of the Tree: " + root.data);
        System.out.println();
        System.out.print("Preorder:  ");
        preorder(root);

        System.out.println();
        System.out.print("Inorder:  ");
        inorder(root);

        System.out.println();
        System.out.print("Postorder:  ");
        postorder(root);
        System.out.println();
        System.out.println("Levelorder:");
        levelorder(root);


        System.out.println("Total number of nodes: "+ countNodes(root));
        System.out.println("Sum of nodes: "+ sumOfNodes(root));
        System.out.println("Height: "+ height(root));
        System.out.println("Diameter: "+ diameter(root));



    }
}
