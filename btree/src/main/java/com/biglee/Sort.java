package main.java.com.biglee;

import java.util.Arrays;

/**
 * @author ：DELL
 * @date ：Created in 2021/6/4 9:00
 * @description：各个排序算法的汇总
 * @version:
 */
public class Sort {
    /**
     * 冒泡排序，稳定性算法,通过n*n次的数字两两交换，完成排序
     */
    public int[] buddleSort(int[] arr){
        int len=arr.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[i]){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                }
            }
        }
        return arr;
    }
    /**
     * 插入排序，稳定性排序，通过拿出一个数，和之前所有的数对比，进行的排序，大于就插入
     */
    public static void insertSort(int[] arr) {
        int length=arr.length;
        if(length<=1) return;
        for (int i = 0; i < length; i++) {
            int value=arr[i];
            int j=i-1;
            for (;j>=0;--j){
                if(arr[j]>value)
                    arr[j+1]=arr[j];
                else break;
            }
            arr[j+1]=value;
        }

    }

    public static void main(String[] args) {
        int[] testArr={2,1,3,4,5,6,8,7};
        insertSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }
    }
