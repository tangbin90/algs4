/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: TangMST
 * Date: 2018/1/30 11:40
 * Description: 最小生成树
 */
package com.itangbin.algs4;

import edu.princeton.cs.algs4.*;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/1/30 11:40
 * @since 1.0.0
 * @description: 〈最小生成树〉
 */
public class TangLazyPrimMST {

    private boolean[] marked;
    private MinPQ<TangEdge> pq;
    private Queue<TangEdge> mst;

    public TangLazyPrimMST(TangEdgeWeightedGraph tangEdgeWeightedGraph){
        int v = tangEdgeWeightedGraph.V();
        marked = new boolean[v];
        pq = new MinPQ<>(v);
        visit(tangEdgeWeightedGraph, 0);

        while(!pq.isEmpty()){
            TangEdge e =pq.delMin();
            int m = e.either();
            int n = e.other(v);
            if(marked[n]&&marked[m])
                continue;
            mst.enqueue(e);
            if(!marked[m]) visit(tangEdgeWeightedGraph,m);
            if(!marked[n]) visit(tangEdgeWeightedGraph,n);
        }
    }

    private void visit(TangEdgeWeightedGraph G, int v){
        marked[v] = true;
        for(TangEdge e : G.adj(v)){
            if(!marked[e.other(v)]) pq.insert(e);
        }
    }

    public Iterable<TangEdge> edges(){
        return mst;
    }

    public double weight(){
        double result = 0.0;
        for(TangEdge te : mst){
            result += te.weight();
        }
        return result;
    }
}
