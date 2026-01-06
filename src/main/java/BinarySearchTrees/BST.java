package BinarySearchTrees;

import java.util.logging.XMLFormatter;

public class BST {

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

    public static Node insert(Node root, int val){

        if(root==null){
            root= new Node(val);
            return root;
        }

        if(val<root.data){
            root.left = insert(root.left,val);
        }

        if(val>root.data){
            root.right = insert(root.right,val);
        }

        return root;

    }

    public static void inorder(Node root){

        if(root==null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+ " ");
        inorder(root.right);

    }

    public static boolean search(Node root, int key){

        if(root==null){
            return false;
        }
        else if(root.data>key){
            return search(root.left,key);
        }
        else if(root.data==key){
            return true;
        }
        else{
            return search(root.right,key);
        }
    }

    public static Node deleteNode(Node root, int val){

        if(val>root.data){
            root.right = deleteNode(root.right, val);
        }
        else if(val<root.data){
            root.left = deleteNode(root.left,val);
        }
        else{

            //Case 1
            if(root.left==null && root.right==null){
                return null;
            }

            //Case 2
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }

            //Case 3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right=deleteNode(root.right,IS.data);

        }

        return root;

    }

    public static Node inorderSuccessor(Node root){

        while(root.left!=null){
            root=root.left;
        }

        return root;

    }

    public static void printInRange(Node root, int x, int y){
        if(root==null){
            return;
        }

        if(root.data>=x && root.data<=y){
            printInRange(root.left,x,y);
            System.out.print(root.data+ " ");
            printInRange(root.right,x,y);
        }
        else if(root.data>y){
            printInRange(root.left,x,y);
        }
        else {
            printInRange(root.right,x,y);
        }



    }



    public static void main(String[] args){

        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root=null;

        for(int i : values){
            root= insert(root, i);
        }

        inorder(root);

        System.out.println();

        if(search(root,1)){
            System.out.println("Found");
        }
        else{
            System.out.println("No Found");
        }

        System.out.println();
        root = deleteNode(root,6);

        inorder(root);

        System.out.println();

        printInRange(root,4,10);

    }
}
