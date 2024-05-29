import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(MyGraph<V> graph, V data) {
        super(graph, graph.getVertex(data));
        bfs(start);
    }

    private void bfs(Vertex<V> start) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex<V> vertex = queue.remove();
            for (Vertex<V> v : vertex.getAdjacentVertices().keySet()) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    edgeTo.put(v, vertex);
                    queue.add(v);
                }
            }
        }
    }
}