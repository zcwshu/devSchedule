package com.atguigu.commonutils;

import java.util.Random;

/**
 * @Author: AndrewBar
 * @Date: Created in 17:09 2021/3/18
 */
public class Fitness {
    /**
     * @param n 需要调度的故障设备数
     * @param repairTime 不同维修员对应的维修时间
     * @param skillScore 不同维修员对应的维修技能分
     * @param arr 传入的粒子序列，代表一种维修顺序
     * @return 返回适应度值
     */

    int[][] repairTime = {{20,25,30,18,36},{46,38,42,36,50},{80,64,74,90,80},{150,120,90,108,80},{120,136,164,192,210}};
    int[][] skillScore = {{7,6,5,8,4},{3,7,5,8,1},{5,8,7,4,5},{2,4,7,6,8},{8,7,6,4,2}};

    public static double fitness(int n,int[] arr){
        double result = 0;

        for (int i = 0; i < n; i++) {
            //random.nextInt(n)

        }

        return result;
    }
}
