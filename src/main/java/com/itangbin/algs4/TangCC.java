package com.itangbin.algs4;

import edu.princeton.cs.algs4.*;

/**
 * @author TangBin
 * @version V1.0
 * @date 28/01/2018 4:25 PM
 */
public class TangCC {
    private int count;
    private TangGraph G;
    private boolean[] marked;
    private int[] id;

    public TangCC(TangGraph G){
        this.G = G;
        marked = new boolean[G.V()];
        id = new int[G.V()];
        count=0;
        for(int i=0;i<G.V();i++) {
            if (!marked[i])
                dfs(G, i);
            else
                count++;
        }
    }

    public boolean connected(int v, int w){
        return id[v]==id[w];
    }

    public int count(){
        return count+1;
    }

    public int id(int v){
        return id[v];
    }

    private void dfs(TangGraph G, int V){
        marked[V] = true;
        id[V] = count;
        for(int v:G.adj(V)){
            if(!marked[v])
                dfs(G,v);
        }
    }


    public static void main(String[] args){
        In in = new In(args[0]);
        Graph G = new Graph(in);
        CC cc = new CC(G);

        // number of connected components
        int m = cc.count();
        StdOut.println(m + " components");

        // compute list of vertices in each connected component
        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
        for (int i = 0; i < m; i++) {
            components[i] = new Queue<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].enqueue(v);
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
