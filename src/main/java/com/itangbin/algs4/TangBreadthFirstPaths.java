/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: TangBreadthFirstPaths
 * Date: 2018/1/26 17:35
 * Description: 广度优先搜索
 */
package com.itangbin.algs4;

import edu.princeton.cs.algs4.Queue;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/1/26 17:35
 * @since 1.0.0
 * @description: 〈广度优先搜索〉
 */
public class TangBreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public TangBreadthFirstPaths(TangGraph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }

    private void  dfs(TangGraph G, int s){
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        while(!queue.isEmpty()){
            for(Integer w: G.adj(s))
                queue.enqueue(w);
            int v = queue.dequeue();
            edgeTo[v]=s;
            dfs(G, v);
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }


}
