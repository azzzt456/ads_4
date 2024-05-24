import java.util.*;

public class WeightedGraph<Vertex> {
    private Map<Vertex, List<Edge<Vertex>>> map ;

    public WeightedGraph() {
        map = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        map.put(vertex, new LinkedList<>());
    }

    public void addEdge(Vertex source, Vertex dest, double weight) {
        Edge<Vertex> edge = new Edge<>(source, dest, weight);
        map.get(source).add(edge);
    }

    public List<Edge<Vertex>> getEdges(Vertex vertex) {
        return map.get(vertex);
    }

    public Set<Vertex> getVertices() {
        return map.keySet();
    }
}
