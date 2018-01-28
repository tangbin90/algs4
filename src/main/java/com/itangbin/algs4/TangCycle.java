package com.itangbin.algs4;

import edu.princeton.cs.algs4.Graph;

/**
 * @author TangBin
 * @version V1.0
 * @date 28/01/2018 4:48 PM
 */
public class TangCycle {
    private boolean[] marked;
    private boolean hashCycle;
    public TangCycle(TangGraph G){
        marked = new boolean[G.V()];
        for(int s = 0;s<G.V();s++){
            if(!marked[s])
                dfs(G,s,s);
        }
    }

    private void dfs(TangGraph graph, int w, int v){
        marked[w] = true;
        for(int tmp: graph.adj(w)){
            if(!marked[tmp])
                dfs(graph,tmp,w);
            else if(tmp!=v) hashCycle = true;
        }
    }
}
