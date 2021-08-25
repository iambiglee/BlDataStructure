package main.java.com.biglee.tree;

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
