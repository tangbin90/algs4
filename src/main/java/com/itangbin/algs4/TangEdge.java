/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: TangEdge
 * Date: 2018/1/30 10:46
 * Description: 边函数
 */
package com.itangbin.algs4;


/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/1/30 10:46
 * @since 1.0.0
 * @description: 〈边函数〉
 */
public class TangEdge implements Comparable<TangEdge>{
    private int v;
    private int w;
    private double weight;

    public TangEdge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight(){
        return weight;
    }

    public int either(){
        return v;
    }

    public int other(int v){
        return this.v==v?w:v;
    }
    @Override
    public int compareTo(TangEdge that){
        if(Math.abs(this.weight-that.weight)<0.0001)
            return 0;
        else if(this.weight-that.weight>0.0001)
            return 1;
        else
            return -1;
    }

    public String toString(){
        return this.v+" "+this.w+" "+this.weight;
    }
}
