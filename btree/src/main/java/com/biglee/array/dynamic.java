package main.java.com.biglee.array;

public class dynamic {
    public static int FindGreatestSumOfSubArray(int[] array) {
        int max=array[0];
        int result=array[0];
        for(int i=1;i<array.length;i++){
            max=Math.max(max+array[i],array[i]);
            result=Math.max(result,max);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a={1,-5,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(a));
    }
}
