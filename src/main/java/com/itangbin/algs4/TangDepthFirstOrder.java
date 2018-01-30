/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: TangDepthFirstOrder
 * Date: 2018/1/29 15:36
 * Description: 前序后序逆后序，拓扑排序
 */
package com.itangbin.algs4;

import edu.princeton.cs.algs4.*;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/1/29 15:36
 * @since 1.0.0
 * @description: 〈前序后序逆后序，拓扑排序〉
 */
public class TangDepthFirstOrder {
    private boolean[] marked;

    private Queue<Integer> preOrder;
    private Queue<Integer> postOrder;
    private Stack<Integer> reverseOrder;

    public TangDepthFirstOrder(Digraph G){
        preOrder = new Queue<>();
        postOrder = new Queue<>();
        reverseOrder = new Stack<>();
        marked = new boolean[G.V()];
        for(int v = 0; v<G.V(); v++)
            if(!marked[v]) dfs(G, v);
    }

    private void dfs(Digraph G, int v){
        preOrder.enqueue(v);
        marked[v]=true;

        for(int m : G.adj(v)){
            if(!marked[m]) dfs(G,m);
        }
        postOrder.enqueue(v);
        reverseOrder.push(v);
    }

    public Iterable<Integer> pre(){
        return preOrder;
    }

    public Iterable<Integer> post(){
        return postOrder;
    }

    public Iterable<Integer> reverse(){
        return reverseOrder;
    }

    public static void main(String[] args) {
        In in = new In("src/main/sources/tinyDG.txt");
        Digraph dg = new Digraph(in);
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(dg);
        TangDepthFirstOrder tangDepthFirstOrder = new TangDepthFirstOrder(dg);
    }

}
