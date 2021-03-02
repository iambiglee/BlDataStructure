package main.java.com.biglee;

import javax.naming.directory.DirContext;
import java.util.LinkedList;
import java.util.Map;

public class BTreeNode {

    int M;
    LinkedList<Integer> values;
    BTreeNode parent;
    LinkedList<BTreeNode> children;


    public BTreeNode() {
        this.values=new LinkedList<Integer>();
        this.children=new LinkedList<BTreeNode>();
    }

    public BTreeNode(int m) {
        this();
        if(m < 3) {
            throw new RuntimeException("The order of B-Tree should be greater than 2.");
        }
        this.M = m;
    }
    
    public BTreeNode(BTreeNode parent) {
        this(parent.M);
        this.parent = parent;
    }
    
    public BTreeNode insert(int e){
        if(isEmpty()){
            values.add(e);
            children.add(new BTreeNode(this));
            return this;
        }
        BTreeNode p=getRoot().search(e);
        return null;
    }

    public boolean isEmpty() {
        if(null==values||values.size()==0){
            return true;
        }
        return false;
    }

    public BTreeNode getRoot() {
        BTreeNode p=this;
        while (!p.isRoot()){
            p=p.parent;
        }
        return p;
    }

    public boolean isRoot(){
        return parent==null;
    }

    public BTreeNode search(int target) {
        if(isEmpty()) {
            return this;
        }
        int valueIndex = 0;
        while(valueIndex < values.size() && values.get(valueIndex) <= target) {
            if(values.get(valueIndex) == target) {
                return this;
            }
            valueIndex++;
        }
        return children.get(valueIndex).search(target);
    }

}
