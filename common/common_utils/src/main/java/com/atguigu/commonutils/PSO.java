package com.atguigu.commonutils;

import java.util.Random;

/**
 * @Author: AndrewBar
 * @Date: Created in 10:46 2021/3/9
 */
public class PSO implements Algorithm{

    public double w;		// 惯性权重系数
    public Particle [] pop;	// 粒子群种群                初始化产生的粒子种群
    public int x_low;	// 变量下边界
    public int x_up;		// 变量上边界
    public double best_fitness;	// 全局最有适应值
    public int[] best_solution;	// 全局最优位置（最优解）
    public int count_Iter=0;		// 当前迭代次数
    public int nVar;				// 变量个数  待维修设备数
    static Random rand1=new Random();// 随机变量生成
    //构造函数,无析构函数
	/*
	构造函数初始化
	*/
    PSO(double w,int nVar,int x_low,int x_up){

        this.w=w;
        this.nVar=nVar;
        this.x_low=x_low;
        this.x_up=x_up;
        this.pop=new Particle [sizePop];
        // 种群初始化
        for(int i=0;i<sizePop;i++){
            pop[i]=new Particle(nVar,x_low,x_up);  				// 初始化每个粒子

            pop[i].fitness=function_fitness(pop[i].position);	// 计算每个粒子的适应值
            pop[i].P_fitness=pop[i].fitness;					// 初始化粒子的最优适应值
            pop[i].P_position=pop[i].position.clone();// 初始化粒子的最优位值，数组的复制用clone，

        }
        //把第一个粒子的适应值和位置初始化给全局变量
        best_fitness=pop[1].fitness;
        ConvertArr ca = new ConvertArr();

        best_solution = ca.doubleToInt(pop[1].position);
                //pop[1].position.clone();

    }
    // 适应值函数
    int[] arr = new int[nVar];
    double newFir = Fitness.fitness(nVar,arr);
    public double function_fitness(double[] var){
        double sum=0;
        for(int i=0;i<nVar;i++)
        {
            sum+=var[i]*var[i];
        }
        return sum;
    }
    /*
    种群搜索过程，粒子更新的方法
    1.先计算粒子的速度，按公式计算，采用基本粒子群算法的更新公式
    2.对出界的速度进行限制
    3.按公式更新粒子的位置
    4.对出界的位置进行限制
    */
    public void up_search(){
        for(int i=0;i<sizePop;i++){
            for(int j=0;j<nVar;j++){
                pop[i].velecity[j]=w*pop[i].velecity[j]+
                        rand1.nextDouble()*(pop[i].P_position[j]-pop[i].position[j])*c1 +
                        rand1.nextDouble()*(best_solution[j]-pop[i].position[j])*c2;
                if(pop[i].velecity[j]>x_up){
                    pop[i].velecity[j]=x_up;
                    if(pop[i].velecity[j]<x_low){
                        pop[i].velecity[j]=x_low;
                    }
                }

                pop[i].position[j]= pop[i].position[j] + pop[i].velecity[j];

                if(pop[i].position[j]>x_up){
                    pop[i].position[j]=x_up;
                    if(pop[i].position[j]<x_low){
                        pop[i].position[j]=x_low;
                    }
                }
            }
        }
    }
    //更新适应值
    public void up_date(){
        for(int i=0;i<this.sizePop;i++){
            //计算适应值
            pop[i].fitness=function_fitness(pop[i].position);
            // 如果个体的适应值大于个体历史最优适应值，则更新个体历史最优适应值，位置信息同样的也更新
            if(pop[i].fitness<pop[i].P_fitness){
                pop[i].P_position=pop[i].position.clone();
                // 如果个体的适应值比全局的适应值优，则更新全局的适应值和位置
                if(pop[i].fitness<best_fitness)
                {
                    best_fitness=pop[i].fitness;
                    ConvertArr ca = new ConvertArr();

                    best_solution=ca.doubleToInt(pop[i].position);
                    //pop[i].position).clone();
                }
            }
        }
    }
    // 显示结果，显示每一次迭代计算后的最优适应值
    public void show_result(int Iter_c){
        System.out.printf("Iteration: %5d fit:%5f\n",Iter_c,best_fitness);
        if(Iter_c==(maxIter-1))
        {
            for(int i=0;i<nVar;i++){
                System.out.println(" "+best_solution[i]);

            }
            System.out.println("The PSO end ,plase look up the result if need!");
        }
    }
    // PSO 程序开始运行
    public void run()
    {	up_date();
        // 按照设置的最大迭代次数迭代计算
        for(int it =0;it<maxIter;it++){

            up_search();	// 速度位置更新
            up_date();		// 适应值的更新
            show_result(it);// 输出结果的显示
        }
    }
}
