package com.atguigu.commonutils;

import java.util.Random;

/**
 * @Author: AndrewBar
 * @Date: Created in 13:41 2021/3/9
 * 粒子类，用于pso在初始化时产生初始粒子和速度
 */
public class Particle {
    public int nVar;               // 变量的个数
    public double[] position;    // 粒子的位置，包含解的信息
    public double[] velecity;    // 粒子的速度
    public double [] P_position;  // 粒子历史最有位置
    public double P_fitness;      // 粒子的历史最优适应值
    public double fitness;        // 粒子的适应值
    public int x_low;          // 粒子的运动边界--下
    public int x_up;		   // 粒子的运动边界--上
    static Random rand1=new Random();   // 随机量生成
    // java 的构造函数（没有析构函数）
    //粒子的初始化

    /**
     * @param nVar 待调度的故障机器数
     * @param x_low 上下边界
     * @param x_up
     */
    Particle(int nVar,int x_low,int x_up){
        position=new double[nVar];
        velecity=new double[nVar];
        P_position=new double[nVar];
        this.x_low=x_low;
        this.x_up=x_up;
        // 初始化在边界内：位置，速度
        for(int i=0;i<nVar;i++){
            position[i]=rand1.nextDouble()*(x_up-x_low)+x_low;
            velecity[i]=1.0*position[i];
        }
    }
}
