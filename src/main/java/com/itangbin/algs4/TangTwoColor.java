package com.itangbin.algs4;

import edu.princeton.cs.algs4.Graph;

/**
 * @author TangBin
 * @version V1.0
 * @date 28/01/2018 5:26 PM
 */
public class TangTwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TangTwoColor(TangGraph G){
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for(int i=0;i<G.V();i++){
            if(!marked[i])
                dfs(G,i);
        }
    }

    private void dfs(TangGraph G, int v){
        marked[v]=true;
        for(int w : G.adj(v)){
            if(!marked[w]){
                color[w] = !color[w];
                dfs(G, w);
            }else if(color[w]==color[v]){
                isTwoColorable = false;
            }
        }
    }

    public boolean isBipartite(){
        return isTwoColorable;
    }
}
