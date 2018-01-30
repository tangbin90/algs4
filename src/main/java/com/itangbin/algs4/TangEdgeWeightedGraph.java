/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: TangEdgeWeightedGraph
 * Date: 2018/1/30 10:53
 * Description: 带权重边的图
 */
package com.itangbin.algs4;

import com.sun.org.apache.xml.internal.serializer.ToStream;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/1/30 10:53
 * @since 1.0.0
 * @description: 〈带权重边的图〉
 */
public class TangEdgeWeightedGraph {
    private int v;
    private int e;
    private Bag<TangEdge>[] adj;
    public TangEdgeWeightedGraph(int V){
        this.v = V;
        this.e = 0;
        adj = (Bag<TangEdge>[]) new Bag[V];
        for(int v=0;v<V;v++){
            adj[v] = new Bag<>();
        }
    }

    public TangEdgeWeightedGraph(In in){
        this.v = in.readInt();
        this.e = in.readInt();
        for(int i=0;i<e;i++) {
            TangEdge tangEdge = new TangEdge(in.readInt(), in.readInt(), in.readDouble());
            this.addEdge(tangEdge);
        }
    }

    public int V(){
        return v;
    }

    public int E(){
        return e;
    }

    public void addEdge(TangEdge e){
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        this.e++;
    }

    public Iterable<TangEdge>  adj(int v){
        return adj[v];
    }

    public Iterable<TangEdge> edges(){
        Queue<TangEdge> queue = new Queue<>();
        for(int v = 0;v<this.v;v++){
            for(TangEdge e: adj[v])
                if(e.other(v)>v) queue.enqueue(e);
        }
        return queue;
    }

}
