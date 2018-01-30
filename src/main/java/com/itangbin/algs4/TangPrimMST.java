/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: TangPrimMST
 * Date: 2018/1/30 22:42
 * Description: 最小生成树
 */
package com.itangbin.algs4;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/1/30 22:42
 * @since 1.0.0
 * @description: 〈最小生成树〉
 */
public class TangPrimMST {
    private TangEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;
    //如果已经在树中了则为true
    private boolean[] marked;

    public TangPrimMST(TangEdgeWeightedGraph G){
        edgeTo = new TangEdge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<>(G.V());

        distTo[0] = 0.0;
        edgeTo[0] = null;
        pq.insert(0, 0.0);
        while(!pq.isEmpty()){
            visit(G, 0);
        }
    }

    private void visit(TangEdgeWeightedGraph G, int v){
        marked[v] = true;
        for(TangEdge e : G.adj(v)){
            int m = e.other(v);
            if(marked[m]) continue;
            if(distTo[m]>e.weight()){
                distTo[m] = e.weight();
                edgeTo[m] = e;
                if(pq.contains(m)) pq.decreaseKey(m,distTo[m]);
                else pq.insert(m,distTo[m]);
            }
        }
    }

    public Iterable<TangEdge> edges() {
        Queue<TangEdge> mst = new Queue<>();
        for (int v = 0; v < edgeTo.length; v++) {
            TangEdge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
    }
}
