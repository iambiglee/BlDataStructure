package main.java.com.biglee;

import java.util.Arrays;

/**
 * @author ：DELL
 * @date ：Created in 2021/6/4 9:00
 * @description：各个排序算法的汇总，tap K 问题
 * @version:
 */
public class Sort {
    /**
     * 冒泡排序，稳定性算法,通过n*n次的数字两两交换，完成排序
     * 依次比较相邻的两个数，将小数放前面，大数放后面。
     */
    public static int[] bubbleSort(int[] arr){
        int len=arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if(arr[j+1]<arr[j]){
                int temp=arr[j+1];
                arr[j+1]=arr[j];
                arr[j]=temp;
                }
            }
        }
        return arr;
    }
    /**
     * 插入排序，稳定性排序，通过拿出一个数，和之前所有的数对比，进行的排序，大于就插入
     * 将一个数据插入到已经排好序的有序数组中，从而得到一个新的，个数加1的数组
     */
    public static void insertSort(int[] arr) {
        int length=arr.length;
        if(length<=1) return;
        for (int i = 0; i < length; i++) {
            int value=arr[i];
            int j=i-1;
            //查找插入的位置
            for (;j>=0;--j){
                if(arr[j]>value)
                    arr[j+1]=arr[j];
                else break;
            }
            arr[j+1]=value;
        }
    }

    /**
     * 选择排序,最好理解的排序方法，先找到元素中最小的数据，然后放到数组开头，然后找第二小的，依次类推
     * @param arr
     */
    public static void selectSort(int[] arr){
        if(null==arr) return;
        int len=arr.length;
        if (len<=1) return;
        for (int i = 0; i < len-1; ++i) {
            int minIndex=i;
            for (int j=i+1;j<len;++j){
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
        selectSort(testArr);
        System.out.println(Arrays.toString(testArr));
        System.out.println(sum(100));
    }
    }
