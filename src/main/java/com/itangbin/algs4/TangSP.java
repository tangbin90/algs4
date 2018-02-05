/**
 * Copyright (C), 2015-2018, 苏宁金融集团
 * Author: TangBin 17082720
 * FileName: TangSP
 * Date: 2018/2/5 17:12
 * Description:
 */
package com.itangbin.algs4;

import edu.princeton.cs.algs4.*;

/**
 * @author: TangBin 17082720 
 * @Email: 17082720@cnsuning.com
 * @create: 2018/2/5 17:12
 * @since 1.0.0
 * @description: 〈〉
 */
public class TangSP {
    private double[] distTo;
    private TangDirectedEdge[] edgeTo;
    public TangSP(TangEdgeWeightedDigraph G, int s){
        distTo = new double[G.V()];
        edgeTo = new TangDirectedEdge[G.V()];
        distTo[s] = 0;
        for(int i=0;i<G.V();i++){
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        edgeTo[s] =null;
    }

    private void relax(TangDirectedEdge e){
        int v = e.from();
        int w = e.to();
        if(distTo[w]>distTo[v]+e.weight()){
            distTo[w] = distTo[v]+e.weight();
            edgeTo[w] = e;
        }
    }

    private void relax(TangEdgeWeightedDigraph G, int v){
        for(TangDirectedEdge e : G.adj(v)){
            if(distTo[e.to()]>distTo[e.from()]+e.weight()){
                distTo[e.to()] = distTo[e.from()]+e.weight();
                edgeTo[e.to()] = e;
            }
        }
    }

    public double distTo(int v){
        return distTo[v];
    }

    public boolean hasPathTo(int v){
        return distTo[v]<Double.POSITIVE_INFINITY;
    }

    Iterable<TangDirectedEdge> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<TangDirectedEdge> path = new Stack<>();
        for(TangDirectedEdge e=edgeTo[v]; e!=null;e = edgeTo[e.from()])
            path.push(e);
        return path;
    }

    public static void main(String[] args){
        TangEdgeWeightedDigraph G;
        G = new TangEdgeWeightedDigraph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        TangSP sp = new TangSP(G, s);

        for(int t = 0; t< G.V(); t++){
            StdOut.print(s + " to " +t);
            StdOut.printf("(%4.2f): ", sp.distTo(t));
            if(sp.hasPathTo(t))
                for(TangDirectedEdge e: sp.pathTo(t))
                    StdOut.print(e+"  ");
            StdOut.println();
        }

    }
}
