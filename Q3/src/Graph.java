import java.util.*;

public class Graph {

    int vertices;
    int[][] adjMatrix;

    Graph(int v) {
        vertices = v;
        adjMatrix = new int[v][v];
    }

    void addEdge(int from, int to) {
        adjMatrix[from][to] = 1;
    }

    void DFS(int u, boolean[] visited, ArrayList<Integer> result) {

        visited[u] = true;

        for (int v = 0; v < vertices; v++) {

            if (adjMatrix[u][v] == 1 && !visited[v]) {
                DFS(v, visited, result);
            }
        }

        result.add(0, u);
    }

    void topologicalSort() {

        boolean[] visited = new boolean[vertices];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {

            if (!visited[i]) {
                DFS(i, visited, result);
            }
        }

        char[] names = {
                'm','n','o','p','q','r','s',
                't','u','v','w','x','y','z'
        };

        System.out.println("Topological Sort:");

        for (int node : result) {
            System.out.print(names[node] + " ");
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(14);

        g.addEdge(0,4);
        g.addEdge(0,5);
        g.addEdge(0,11);

        g.addEdge(1,2);
        g.addEdge(1,4);
        g.addEdge(1,8);

        g.addEdge(2,5);
        g.addEdge(2,6);
        g.addEdge(2,9);

        g.addEdge(3,2);
        g.addEdge(3,6);
        g.addEdge(3,13);

        g.addEdge(4,7);

        g.addEdge(5,8);
        g.addEdge(5,12);

        g.addEdge(6,5);

        g.addEdge(8,7);

        g.addEdge(9,10);
        g.addEdge(9,11);

        g.addEdge(12,9);

        g.addEdge(10,13);

        g.topologicalSort();
    }
}