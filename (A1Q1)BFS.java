import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class BFS {
    public static void bfs(List<List<Integer>> adjList, int startingNode) {
        boolean[] visited = new boolean[adjList.size()];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(startingNode);
        visited[startingNode] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
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
        System.out.println("BFS traversal starting from node 0:");
        bfs(adjList, 0);
    }
}