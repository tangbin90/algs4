/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: TangKosaraju
 * Date: 2018/1/30 9:32
 * Description: Kosaraju算法
 */
package com.itangbin.algs4;

import edu.princeton.cs.algs4.*;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/1/30 9:32
 * @since 1.0.0
 * @description: 〈Kosaraju算法〉
 */
public class TangKosaraju {
    private boolean[] marked;
    private int[] id;
    private int count;

    public TangKosaraju(Digraph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        count = 0;
        TangDepthFirstOrder order = new TangDepthFirstOrder(G.reverse());

        for(int v : order.reverse()){
            if(!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    public void dfs(Digraph G, int V){
        marked[V] = true;
        id[V] = count;
        for(int m : G.adj(V)){
            if(!marked[m])
                dfs(G, m);
        }
    }

    public boolean stronglyConected(int v, int w){
        return id[v]==id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }


    public static void main(String[] args){
        In in = new In("src/main/sources/tinyDG.txt");
        Digraph dg = new Digraph(in);
        TangKosaraju tangKosaraju = new TangKosaraju(dg);
//        KosarajuSharirSCC tangKosaraju = new KosarajuSharirSCC(dg);
        int m = tangKosaraju.count();
        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];

        for (int i = 0; i < m; i++) {
            components[i] = new Queue<>();
        }
        for (int v = 0; v < dg.V(); v++) {
            components[tangKosaraju.id(v)].enqueue(v);
        }

        // print results
        for (int i = 0; i < m; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

    }
}
