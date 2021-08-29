package main.java.com.biglee.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public void addNode(int value){
        root=addNode(root,value);
    }

    private Node addNode(Node root, int value) {
        if(root==null) return new Node(value);
        if(value<root.data){ root.left=addNode(root.left,value);}
        else if(value>root.data) {root.right=addNode(root.right,value);}
        return root;
    }

    public boolean containNode(Node current,int value){
        if(current==null) return false;
        if(value==current.data) return true;
        return value<current.data?containNode(current.left,value):containNode(current.right,value);
    }

    public boolean containNode(int value){
        return containNode(root,value);
    }

    public Node deleteNode(Node current,int value){
        if(current==null) return null;
        if(value==current.data){
            if(current.left==null&&current.right==null) return null;
            if(current.left==null) return current.right;
            if(current.right==null) return current.left;
            int smallestValue=findSmallestValue(current.right);
            current.data=smallestValue;
            current.right=deleteNode(current.right,smallestValue);
            return current;
        }
        if(value<current.data){
            current.left=deleteNode(current.left,value);
            return current;
        }
        current.right=deleteNode(current.right,value);
        return current;
    }

    public int findSmallestValue(Node root){
        return root.left==null? root.data : findSmallestValue(root.right);
    }

    public void traverLevelOrder(Node root){
        if(root==null){return;}
        Queue<Node> nodes=new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            Node node=nodes.remove();
            System.out.println(node.data);
            if (node.left!=null){
                nodes.add(node.left);
            }
            if (node.right!=null){
                nodes.add(node.right);
            }
        }
    }

    public void traverPostOrder(Node root){
        if (root!=null){
            System.out.println(root.data);
            traverPostOrder(root.left);
            traverPostOrder(root.right);
        }
    }


    class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
}
