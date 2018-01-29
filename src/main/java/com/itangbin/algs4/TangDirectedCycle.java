/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: TangDirectedCycle
 * Date: 2018/1/29 15:00
 * Description: 有向环检测
 */
package com.itangbin.algs4;

import edu.princeton.cs.algs4.Digraph;

import java.util.Stack;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/1/29 15:00
 * @since 1.0.0
 * @description: 〈有向环检测〉
 */
public class TangDirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public TangDirectedCycle(Digraph G){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        cycle = new Stack<>();
        onStack = new boolean[G.V()];
        for(int i=0;i<G.V();i++)
            if(!marked[i]) dfs(G, i);
    }

    private void dfs(Digraph G, int i){
        onStack[i] = true;
        marked[i] = true;
        for(int m : G.adj(i)){
            if(!marked[m]) {
                edgeTo[m]=i;
                dfs(G, m);
            }
            else if(onStack[m]){
                for(int k=i;k!=m;k=edgeTo[k])
                    cycle.push(k);
                cycle.push(m);
                cycle.push(i);
            }
        }
        onStack[i] = false;
    }

    public boolean hasCycle(){
        return cycle !=null;
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }
}
