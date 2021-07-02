package ir.ac.kntu;

import java.util.*;

public class MatrixShortestPath {

    public MatrixShortestPath(int vertices, int[] dis, int[][] graph) {
        this.dis = dis;
        this.vertices = vertices;
        this.graph = graph;
    }

    static List<Integer> path2 = new ArrayList<>();

    static final List<List<Integer>> paths = new ArrayList<>();
    private final int[] dis;// Path dis[i] = j, the shortest path j from 1 to node i by default
    protected static int[] path;// record route
    private final int vertices;// points
    private final int[][] graph;// Leading matrix

    // BFS shortest path
    public void Bfs(int u) {

        path[u] = -1;// starting point
        // The source point is initialized as visited
        dis[u] = 0;
        Queue<Integer> qu = new LinkedList<>();// queue
        qu.offer(u);// Add source point to enter
        while (!qu.isEmpty()) {
            u = qu.poll();// Pop up the earliest
            // spread by u point
            for (int i = 0; i < vertices; i++) {
				/*
				 dis[i] == -1: whether the representative has visited
				 Because of the unweighted graph, the edge weight is 1 by default, and there is no need to judge the occurrence of node k. The length from node i to node j> node i to node k + the length from node k to node j
				 G[u][i] == 1, there is a path from point u to point i
				*/
                if (dis[i] == -1 && graph[u][i] == 1) {
                    // Update path: +1 for the path from the source point to point u, because there is no right graph, only +1
                    dis[i] = dis[u] + 1;
                    // record path
                    path[i] = u;
                    // add to the queue
                    qu.offer(i);
                }
            }
        }
    }

    // print path
    public static void printPath(int u) {
        //path2.clear();
        // If it is -1, it means reaching the starting point
        if (path[u] == -1) {
            path2.add(u);
            System.out.print("path:" + u + "->");
        } else {
            // previous level
            printPath(path[u]);
            // End of recursion, print path
            path2.add(u);
            System.out.print(u + "->");
        }
    }

}