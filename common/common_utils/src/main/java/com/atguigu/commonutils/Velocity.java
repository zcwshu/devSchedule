package com.atguigu.commonutils;

/**
 * @Author: AndrewBar
 * @Date: Created in 20:10 2021/3/9
 */
public class Velocity {
    // store the Velocity in an array to accommodate multi-dimensional problem space
    //将速度存储在数组中以适应多维问题空间
    private double[] vel;

    public Velocity(double[] vel) {
        super();
        this.vel = vel;
    }

    public double[] getPos() {
        return vel;
    }

    public void setPos(double[] vel) {
        this.vel = vel;
    }
}
