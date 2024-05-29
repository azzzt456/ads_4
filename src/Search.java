import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Search<V> {
    protected MyGraph<V> graph;
    protected Set<Vertex<V>> visited;
    protected Map<Vertex<V>, Vertex<V>> edgeTo;
    protected Vertex<V> start;

    public Search(MyGraph<V> graph, Vertex<V> start) {
        this.graph = graph;
        this.visited = new HashSet<>();
        this.edgeTo = new HashMap<>();
        this.start = start;
    }

    public boolean hasPathTo(Vertex<V> vertex) {
        return visited.contains(vertex);
    }

    public Iterable<V> pathTo(V data) {
        Vertex<V> vertex = graph.getVertex(data);
        if (!hasPathTo(vertex)) {
            return null;
        }
        LinkedList<V> path = new LinkedList<>();
        for (Vertex<V> v = vertex; v != start; v = edgeTo.get(v)) {
            path.push(v.getData());
        }
        path.push(start.getData());
        return path;
    }
}
