package com.atguigu.commonutils;

/**
 * @Author: AndrewBar
 * @Date: Created in 16:23 2021/3/19
 */
public class ConvertArr {
    public double[] intToDouble(int[] arr1){
        int n = arr1.length;
        double[] arr2 = new double[n];
        for (int i = 0; i < n; i++){
            arr2[i] = (double) arr1[i];
        }
        return arr2;
    }

    public int[] doubleToInt(double[] arr2){
        int n = arr2.length;
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++){
            arr1[i] = (int) arr2[i];
        }
        return arr1;
    }
}
