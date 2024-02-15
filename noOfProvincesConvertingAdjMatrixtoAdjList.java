import java.util.*;

public class noOfProvincesConvertingAdjMatrixtoAdjList {
    public static int numOfProvinces(ArrayList<ArrayList<Integer>> adjMatrix, int V) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        int visited[] = new int[V];
        int count = 0;

        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        // to change given adjacency matrix in arraylist form to adj list in array list form 

        for(int row = 0; row < V; row++) {
            for(int col = 0; col < V; col++) {
                // self nodes are not considered
                if(adjMatrix.get(row).get(col) == 1 && row != col) {
                    adjList.get(row).add(col);
                    adjList.get(col).add(row);
                }
            }
        }

        for(int currentNode = 0; currentNode < V; currentNode++) {
            if(visited[currentNode] == 0) {
                count++;
                dfs(currentNode, adjList, visited);
            }
        }
        return count;
    }

    // dfs traversal
    private static void dfs(int currentNode, ArrayList<ArrayList<Integer>> adjList, int visited[]) {
        visited[currentNode] = 1;

        for(Integer currentNodeNeighbour: adjList.get(currentNode)) {
            if(visited[currentNodeNeighbour] == 0) {
                dfs(currentNodeNeighbour, adjList, visited);
            }
        }
    }
    
    public static void main(String[] args) {
        // given adjacency matrix

        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();
        adjMatrix.add(new ArrayList<>());
        adjMatrix.get(0).add(0, 1);
        adjMatrix.get(0).add(1, 0);
        adjMatrix.get(0).add(2, 1);
        adjMatrix.add(new ArrayList<Integer>());
        adjMatrix.get(1).add(0, 0);
        adjMatrix.get(1).add(1, 1);
        adjMatrix.get(1).add(2, 0);
        adjMatrix.add(new ArrayList<Integer>());
        adjMatrix.get(2).add(0, 1);
        adjMatrix.get(2).add(1, 0);
        adjMatrix.get(2).add(2, 1);

        noOfProvincesConvertingAdjMatrixtoAdjList obj = new noOfProvincesConvertingAdjMatrixtoAdjList();

        System.out.println(obj.numOfProvinces(adjMatrix, 3));

    }
}
