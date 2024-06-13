import java.util.ArrayList;
import java.util.List;
public class DFS {
    public static void dfs(List<List<Integer>> adjList, int startingNode, boolean[] visited) {
        visited[startingNode] = true;
        System.out.print(startingNode + " ");
        for (int neighbor : adjList.get(startingNode)) {
            if (!visited[neighbor]) {
                dfs(adjList, neighbor, visited);
            }
        }
    }
    public static void dfsTraversal(List<List<Integer>> adjList, int startingNode) {
        boolean[] visited = new boolean[adjList.size()];
        dfs(adjList, startingNode, visited);
    }
    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(2);
        adjList.get(1).add(3);
        adjList.get(2).add(4);
        adjList.get(3).add(4);
        adjList.get(3).add(5);
        System.out.println("DFS traversal starting from node 0:");
        dfsTraversal(adjList, 0);
    }
}