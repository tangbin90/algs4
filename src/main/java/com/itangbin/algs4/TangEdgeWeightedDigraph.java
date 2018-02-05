/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: TangEdgeWeightedDigraph
 * Date: 2018/2/5 17:01
 * Description: 加权有向图的表示
 */
package com.itangbin.algs4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/2/5 17:01
 * @since 1.0.0
 * @description: 〈加权有向图的表示〉
 */
public class TangEdgeWeightedDigraph {
    private int V;
    private int E;
    private Bag<TangDirectedEdge>[] adj;

    public TangEdgeWeightedDigraph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<TangDirectedEdge>[]) new Bag[V];
        for(int v = 0; v<V; v++){
            adj[v] = new Bag<>();
        }
    }

    public TangEdgeWeightedDigraph(In in){
        this.V = in.readInt();
        this.E = in.readInt();
        for(int i=0;i<E;i++) {
            TangDirectedEdge tangEdge = new TangDirectedEdge(in.readInt(), in.readInt(), in.readDouble());
            this.addEdge(tangEdge);
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(TangDirectedEdge e){
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<TangDirectedEdge> adj(int v){
        return adj[v];
    }

    public Iterable<TangDirectedEdge> edges(){
        Bag<TangDirectedEdge> bag = new Bag<>();
        for(int v = 0;v<V; v++){
            for(TangDirectedEdge e : adj[v])
                bag.add(e);
        }
        return bag;
    }

}
