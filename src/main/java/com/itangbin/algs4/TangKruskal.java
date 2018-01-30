/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: TangKruskal
 * Date: 2018/1/30 23:24
 * Description: Kruskal算法
 */
package com.itangbin.algs4;

import edu.princeton.cs.algs4.*;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/1/30 23:24
 * @since 1.0.0
 * @description: 〈Kruskal算法〉
 */
public class TangKruskal {
    private Queue<TangEdge> mst;

    public TangKruskal(TangEdgeWeightedGraph G){
        mst = new Queue<TangEdge>();
        MinPQ<TangEdge> pq = new MinPQ<>();
        for (TangEdge e : G.edges()) {
            pq.insert(e);
        }
        UF uf = new UF(G.V());
        while(!pq.isEmpty()){
            TangEdge te = pq.delMin();
            int v = te.either();
            int w = te.other(v);
            if(uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.enqueue(te);
        }

    }
}
