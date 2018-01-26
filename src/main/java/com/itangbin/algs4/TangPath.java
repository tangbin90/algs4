/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: TangPath
 * Date: 2018/1/26 16:42
 * Description: 深度优先搜索路径
 */
package com.itangbin.algs4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;


/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/1/26 16:42
 * @since 1.0.0
 * @description: 〈深度优先搜索路径〉
 */
public class TangPath {
    private  TangGraph graph;
    private int source;
    private int[] path;
    private boolean[] marked;
    public TangPath(TangGraph G, int s){
        this.graph = G;
        this.source = s;
        path = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    private void dfs(TangGraph G, int s){
        marked[s] = true;
        for(int w: G.adj(s)){
            if(!marked[w]) {
                path[w]=s;
                dfs(G,w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!marked[v])
            return null;
        Stack<Integer> paths = new Stack<>();
        for(int i=v;i!=source;i=path[i]){
            paths.push(i);
        }
        paths.push(source);
        return paths;
    }

    public static void main(String[] args){
        TangGraph G = new TangGraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        TangPath search = new TangPath(G, s);
        for(int v=0; v<G.V();v++){
            StdOut.print(s+" to "+v+":");
            if(search.hasPathTo(v)){
                for(int x : search.pathTo(v)){
                    if(x==s) StdOut.print(x);
                    else StdOut.print("-"+x);
                }
            }
            StdOut.println();
        }
    }
}
