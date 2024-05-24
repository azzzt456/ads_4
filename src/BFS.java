import java.util.*;

public class BFS<Vertex> {
    public List<Vertex> bfs(Vertex start, Map<Vertex, List<Edge<Vertex>>> graph) {
        List<Vertex> visited = new ArrayList<>();
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> visitedSet = new HashSet<>();

        queue.add(start);
        visitedSet.add(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            visited.add(current);

            for (Edge<Vertex> edge : graph.get(current)) {
                Vertex neighbor = edge.getDest();
                if (!visitedSet.contains(neighbor)) {
                    queue.add(neighbor);
                    visitedSet.add(neighbor);
                }
            }
        }

        return visited;
    }
}
