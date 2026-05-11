import java.util.*;

class GraphMatrix {

    int[][] adjMatrix;
    int n;

    GraphMatrix(int n) {
        this.n = n;
        adjMatrix = new int[n][n];
    }

    void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1; // remove for directed graph
    }

    boolean hasEdge(int u, int v) {
        return adjMatrix[u][v] == 1;
    }

    void display() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class GraphList {

    ArrayList<ArrayList<Integer>> adjList;
    int n;

    GraphList(int n) {
        this.n = n;
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    boolean hasEdge(int u, int v) {
        return adjList.get(u).contains(v);
    }

    void display() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " -> ");
            for (int node : adjList.get(i)) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}

public class Main {

    public static void main(String[] args) {

        int n = 4;

        GraphMatrix gm = new GraphMatrix(n);
        GraphList gl = new GraphList(n);

        // Creating a complete graph (every vertex connected to every other)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                gm.addEdge(i, j);
                gl.addEdge(i, j);
            }
        }
        gm.display();
        System.out.println();
        gl.display();
    }
}