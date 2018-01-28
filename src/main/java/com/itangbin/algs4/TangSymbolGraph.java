package com.itangbin.algs4;

import edu.princeton.cs.algs4.Graph;
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
        while(input!=null && input.hasNextLine()){
            String[] inString = input.readLine().split(delim);
            for(String tmp : inString){
                if(nameNumST.contains(tmp))
                    nameNumST.put();
            }

        }
    }

    public boolean contains(String key){

    }

    public int index(String key){

    }

    public String name(int v){

    }

    public TangGraph tangGraph(){

    }
}
