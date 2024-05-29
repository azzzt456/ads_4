import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    public DijkstraSearch(MyGraph<V> graph, V data) {
        super(graph, graph.getVertex(data));
        dijkstra(graph, start);
    }

    private void dijkstra(MyGraph<V> graph, Vertex<V> start) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparing(distances::get));
        Set<Vertex<V>> settled = new HashSet<>();

        for (Vertex<V> vertex : graph.map.values()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);
        pq.add(start);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();
            if (!settled.add(current)) {
                continue;
            }

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double altDist = distances.get(current) + weight;

                if (altDist < distances.get(neighbor)) {
                    distances.put(neighbor, altDist);
                    edgeTo.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }
}
