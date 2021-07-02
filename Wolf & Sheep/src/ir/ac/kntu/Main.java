package ir.ac.kntu;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int vertices, edges;
        Scanner scanner = new Scanner(System.in);
        vertices = scanner.nextInt();// points
        edges = scanner.nextInt();// number of edges
        // Initialize
        int[][] graph;
        int[] dis;
        graph = new int[vertices][vertices];
        dis = new int[vertices];
        MatrixShortestPath matrixShortestPath = new MatrixShortestPath(vertices, dis, graph);
        MatrixShortestPath.path = new int[vertices];
        // The path length is initialized to -1, which not only represents the path length
        // from the source point to point i, but also represents whether it has been visited
        Arrays.fill(dis, -1);
        // input side
        int u, v;

        for (int i = 0; i < edges; i++) {
            u = scanner.nextInt();
            v = scanner.nextInt();
            graph[u][v] = 1; // directed graph
        }

        // The path from source


        matrixShortestPath.Bfs(0);

        MatrixShortestPath.printPath(vertices - 1);
        MatrixShortestPath.paths.add(MatrixShortestPath.path2);
        System.out.println(MatrixShortestPath.path2.toString());

        System.out.println();


        for (int i = 0; i < MatrixShortestPath.path2.size() - 1; i++) {

            graph[MatrixShortestPath.path2.get(i)][MatrixShortestPath.path2.get(i + 1)] = 0;

        }

        for (int i = 0; i < MatrixShortestPath.path.length; i++) {
            MatrixShortestPath.path[i] = 0;
            dis[i] = -1;
        }
        matrixShortestPath.Bfs(0);
        MatrixShortestPath.path2.clear();
        MatrixShortestPath.printPath(vertices - 1);
        MatrixShortestPath.paths.add(MatrixShortestPath.path2);
        System.out.println(MatrixShortestPath.path2.toString());

        System.out.println();


    }
}
