/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: TangSearch
 * Date: 2018/1/26 16:15
 * Description: 搜索算法
 */
package com.itangbin.algs4;

import edu.princeton.cs.algs4.TangGraph;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/1/26 16:15
 * @since 1.0.0
 * @description: 〈搜索算法，寻找和S连通的所有顶点〉
 */
public class TangDeepFirstSearch {
    private boolean[] marked;
    private TangGraph graph;
    private int source;

    public TangDeepFirstSearch(TangGraph graph, int s){
        this.graph = graph;
        this.source = s;
        marked = new boolean[graph.V()];
        dfs(graph,this.source);
    }

    private void dfs(TangGraph graph, int v){
        marked[v] = true;
        for(int w: graph.adj(v)){
            if(!marked[w])
                dfs(graph,w);
        }
    }

    public boolean marked(int v){
        return marked[v];
    }


}
