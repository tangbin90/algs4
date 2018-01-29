package com.itangbin.algs4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

/**
 * @author TangBin
 * @version V1.0
 * @date 28/01/2018 5:42 PM
 */
public class TangSymbolGraph {
    private String[] nameMap;
    private ST<String, Integer> nameNumST;
    private TangGraph G;

    public TangSymbolGraph(String filename, String delim){
        In input = new In(filename);
        int count = 0;
        while(input.hasNextLine()){
            String[] inString = input.readLine().split(delim);
            for(String tmp : inString){
                if(!nameNumST.contains(tmp))
                    nameNumST.put(tmp, count++);
            }
        }
        nameMap = new String[nameNumST.size()];
        for(String key : nameNumST.keys()){
            nameMap[nameNumST.get(key)] = key;
        }

        G = new TangGraph(nameNumST.size());
        //初始化图
        while(input.hasNextLine()){
            String[] inString = input.readLine().split(delim);
            String name = inString[0];
            for(int i=1; i<inString.length;i++){
                G.addEdge(nameNumST.get(name),nameNumST.get(inString[i]));
            }
        }
    }

    public boolean contains(String key){
        return nameNumST.contains(key);
    }

    public int index(String key){
        return nameNumST.get(key);
    }

    public String name(int v){
        return nameMap[v];
    }

    public TangGraph tangGraph(){
        return G;
    }
}
