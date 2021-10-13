package main.java.com.biglee.lru;

import java.util.HashMap;

public class LruCache {
    class Node{
        int key,value;
        Node pre,next;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    class DoubleList{
        private Node head,tail;
        private int size;
        //双链表,初始化节点
        public DoubleList(){
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.pre=head;
            size=0;
        }
        //尾部添加,添加最新的代码
        public void addLast(Node x){
            x.pre=tail.pre;
            x.next=tail;
            tail.pre.next=x;
            tail.pre=x;
            size++;
        }
        //随机 Remove一个 Key
        public Node remove(Node x){
            x.pre.next=x.next;
            x.next.pre=x.pre;
            size--;
            return x;
        }
        //删除第一个,也是最旧的 key
        public Node removeFirst(){
            if(head.next==tail){
                return null;
            }
            return remove(head.next);
        }
    }
    private HashMap<Integer,Node> map;
    private DoubleList cache;
    private int capacity;
    public LruCache(int capacity){
        this.capacity=capacity;
        map=new HashMap<>();
        cache=new DoubleList();
    }
    private void makeRecently(int key){
        Node x=map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }
    private void addRecently(int key,int val){
        Node node=new Node(key,val);
        cache.addLast(node);
        map.put(key,node);
    }

    private void deletedKey(int key){
        Node x=map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    private void removeLastRecently(){
        Node node = cache.removeFirst();
        map.remove(node);
    }
    //主要获取这个 get,同时要刷新 get的位置
    public Integer get(int key){
        if(!map.containsKey(key)){
            return null;
        }
        makeRecently(key);
        return map.get(key).value;
    }
    //数据放进去,同时保证有数据的要刷新
    public void put(int key,int value){
        if(map.containsKey(key)){
            deletedKey(key);
            addRecently(key,value);
            return;
        }
        if(capacity==cache.size) removeLastRecently();
        addRecently(key,value);
    }
}
