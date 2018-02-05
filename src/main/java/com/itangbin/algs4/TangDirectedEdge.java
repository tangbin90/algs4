/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: TangDirectedEdge
 * Date: 2018/2/5 16:57
 * Description: 加权有向图的数据结构
 */
package com.itangbin.algs4;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/2/5 16:57
 * @since 1.0.0
 * @description: 〈加权有向图的数据结构〉
 */
public class TangDirectedEdge {
    private int V;
    private int W;
    private double weight;

    public TangDirectedEdge(int v, int w, double weight){
        this.V = v;
        this.W = w;
        this.weight = weight;
    }

    public double weight(){
        return this.weight;
    }

    public int from(){
        return this.V;
    }

    public int to(){
        return this.W;
    }

    public String toString(){
        return this.V + " "+ this.W+ " "+this.weight;
    }
}
