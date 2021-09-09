package main.java.com.biglee;

import java.util.Arrays;

/**
 * @author ：DELL
 * @date ：Created in 2021/6/4 9:00
 * @description：各个排序算法的汇总，top K 问题
 * @version:
 */
public class Sort {

    /**
     * 最基础的，找到数组中最小的值,
     * 这个忘记就尴尬了
     */
    public static int findMin(int[] arr){
        int min=arr[0];
        int len=arr.length;
        for (int i = 0; i <len ; i++) {
            if (arr[i]<min){min=arr[i];}
        }
        return min;
    }


    /**
     * 冒泡排序，稳定性算法,通过n*n次的数字两两交换，完成排序
     * 依次比较相邻的两个数，将小数放前面，大数放后面。
     */
    public static int[] bubbleSort(int[] arr){
        int len=arr.length;
        for (int i = 0; i < len; i++) {
            //在[0,len-i]的区间，可以确保最大值在后面
            //j=1的时候，是为了确保最小的数字不用比，会数组越界
            for (int j = 1; j < len-i; j++) {
                if(arr[j]<arr[j-1]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                }
            }
        }
        return arr;
    }
    /**
     * 插入排序，稳定性排序，通过拿出一个数，和之前所有的数对比，进行的排序，大于就插入
     * 将一个数据插入到已经排好序的有序数组中，从而得到一个新的，个数加1的数组
     * 动图见https://www.cnblogs.com/coding-996/p/12275710.html
     */
    public static void insertSort(int[] arr) {
        int length=arr.length;
        if(length<=1) return;
        for (int i = 0; i < length; i++) {
            int value=arr[i];
            //j 拿出来的目的是为了不用每次都交换值
            int j=i-1;
            //在0到i-1的有序数组中，找到比i大的值，如果有，该值向前移动一位
            for (;j>=0;j--){
                if(arr[j]>value)
                    arr[j+1]=arr[j];
                else break;
            }
            arr[j+1]=value;
        }
    }

    /**
     * 选择排序,最好理解的排序方法，先找到元素中最小的数据，然后放到数组开头，然后在剩下的数组，中，找到最小的，依次类推
     * @param arr
     */
    public static void selectSort(int[] arr){
        if(null==arr) return;
        int len=arr.length;
        if (len<=1) return;
        for (int i = 0; i < len; i++) {
            //这个i,就是每次循环数组的开头
            int minIndex=i;
            //查找剩下数组的最小值的下表
            for (int j=i+1;j<len;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            int tmp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=tmp;
        }
    }

    /**
     * 递归求和
     * @param i
     */
    public static int sum(int i){
        if(i<=1){return 1;}
        else
            return i+sum(i-1);
    }

    public static void main(String[] args) {
        int[] testArr={2,1,3,9,5,7,8,7};
        insertSort(testArr);
        System.out.println(Arrays.toString(testArr));
        System.out.println(sum(100));
    }
    }
