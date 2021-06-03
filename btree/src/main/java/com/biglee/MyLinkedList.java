package main.java.com.biglee;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

/**
 * https://www.cnblogs.com/byrhuangqiang/p/4311336.html
 * https://github.com/wangzheng0822/algo
 * @param <E>
 */
public class MyLinkedList <E>{

    //哨兵模式，虚拟头结点
    private Node dummyHead;
    int size;
    private class Node{
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }


    public MyLinkedList(){
        dummyHead=new Node();
        size=0;
    }
    /**
     * 指定位置插入链表结点
     */
    public void add(int index,E e){
        if(index<0||index>size){
            throw new IllegalArgumentException("Add fail, Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev=prev.next;
        }
        prev.next=new Node(e,prev.next);
        size++;
    }
    /**
     * 获得链表index处的元素e
     */
    public E get(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("Add fail, Illegal index.");
        }
        Node cur=dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
        return cur.e;
    }

    /**
     * 修改第index 处的元素e
     */
    public void set(int index,E e){
        if(index<0||index>size){
            throw new IllegalArgumentException("Add fail, Illegal index.");
        }
        Node cur=dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
        cur.e=e;
    }
    /**
     * 删除第index 处的元素
     */
    public E remove(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("Add fail, Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode=prev.next;
        prev.next=retNode.next;
        retNode.next=null;
        size--;
        return retNode.e;
    }

    /**
     * 查找链表处是否有元素e
     */
    public boolean contains(E e){
        Node cur=dummyHead.next;
        while (cur!=null){
            if(cur.e.equals(e)) return true;
            cur=cur.next;
        }
        return false;
    }
    public Node ResverNode(Node head){
        Node reversedHead=head;
        Node node=head;
        Node prev=null;
        while (node!=null){
            Node next = node.next;
            if(next==null) reversedHead=node;
            node.next=prev;
            prev=node;
            node=next;
        }
        head=reversedHead;
        return head;
    }
    public Node reverse(Node head){
        Node left=null;
        Node right=null;
        while (head!=null){
            right=head.next;
            head.next=left;
            left=head;
            head=right;
        }
        return left;
    }

}
