package main.java.com.biglee.queue;

import java.util.Stack;

/**
 * @author ：DELL
 * @date ：Created in 2021/8/29 23:16
 * @description：
 * @version:
 */
public class StackImplQueue {
    private Stack<Integer> stackA=new Stack<>();
    private Stack<Integer> stackB=new Stack<>();

    /**
     * 入队
     * @param element
     */
    public void inQueue(int element){
        stackA.push(element);
    }

    /**
     * 出队
     * @return
     */
    public Integer outQueue(){
        if (stackB.isEmpty()){
            if (stackA.empty()){return null;}
            fetchFromStackA();
        }
        return stackB.pop();
    }

    private void fetchFromStackA(){
        while (!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }
}
