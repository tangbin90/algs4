/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: Graph
 * Date: 2018/1/26 15:59
 * Description: 图的基本结构
 */
package com.itangbin.algs4;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/1/26 15:59
 * @since 1.0.0
 * @description: 〈图的基本结构〉
 */
public class TangGraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public TangGraph(int V){
        this.V = V;
        this.adj = (Bag<Integer>[]) new Bag[V];
        for(int i=0;i<V;i++){
            adj[i] = new Bag<>();
        }
    }

    public TangGraph(In in){
        this.V = in.readInt();
        int E = in.readInt();
        this.adj = (Bag<Integer>[]) new Bag[V];
        for(int i=0;i<V;i++){
            adj[i] = new Bag<>();
        }
        for(int i=0;i<E;i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }

    private void addEdge(int v, int w){
        if(v>V||w>V)
            return;
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public String toString(){
        return "";
    }

}
