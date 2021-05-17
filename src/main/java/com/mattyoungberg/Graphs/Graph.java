package com.mattyoungberg.Graphs;

import java.util.*;

public class Graph {

    private final int MAX_VERTS;
    private final Vertex[] vertexList;
    private final int[][] adjMat;
    private int nVerts;

    public Graph(int maxVertices) {
        this.MAX_VERTS = maxVertices;
        this.vertexList = new Vertex[maxVertices];
        this.adjMat = new int[maxVertices][maxVertices];
        this.nVerts = 0;
    }

    static class Vertex {
        public char label;
        public boolean wasVisited;

        Vertex(char label) {
            this.label = label;
            this.wasVisited = false;
        }
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addUndirectedEdge(int start, int end) {
        if (start < nVerts && end < nVerts) {
            adjMat[start][end] = 1;
            adjMat[end][start] = 1;
        }
    }

    public void addDirectedEdge(int start, int end) {
        if (start < nVerts && end < nVerts)
            adjMat[start][end] = 1;
    }

    public char[] dfs() {
        List<Character> list = new ArrayList<>(nVerts);
        Stack<Integer> stack = new Stack<>();
        vertexList[0].wasVisited = true;
        list.add(vertexList[0].label);
        stack.push(0);

        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1)
                stack.pop();
            else {
                vertexList[v].wasVisited = true;
                list.add(vertexList[v].label);
                stack.push(v);
            }
        }

        for (int i = 0; i < nVerts; i++)
            vertexList[i].wasVisited = false;

        return convertCharListToArray(list);
    }

    public char[] bfs() {
        List<Character> list = new ArrayList<>(nVerts);
        Queue<Integer> queue = new LinkedList<>();
        vertexList[0].wasVisited = true;
        list.add(vertexList[0].label);
        queue.add(0);

        int v1, v2;

        while (!queue.isEmpty()) {
            v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                list.add(vertexList[v2].label);
                queue.add(v2);
            }
        }

        for (int i = 0; i < nVerts; i++)
            vertexList[i].wasVisited = false;

        return convertCharListToArray(list);
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++)
            if (adjMat[v][i] == 1 && !vertexList[i].wasVisited)
                return i;
        return -1;
    }

    private char[] convertCharListToArray(List<Character> characterList) {
        char[] arrayToReturn = new char[characterList.size()];
        for (int i = 0; i < characterList.size(); i++)
            arrayToReturn[i] = characterList.get(i);
        return arrayToReturn;
    }
}
