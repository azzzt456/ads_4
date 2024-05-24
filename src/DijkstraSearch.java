import java.util.*;

public class DijkstraSearch<Vertex> {
    public Map<Vertex, Double> dijkstra(Vertex source, Map<Vertex, List<Edge<Vertex>>> graph) {
        Map<Vertex, Double> distances = new HashMap<>();
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparing(distances::get));
        Map<Vertex, Vertex> previous = new HashMap<>();

        for (Vertex vertex : graph.keySet()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
            previous.put(vertex, null);
        }
        distances.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex current = pq.poll();

            for (Edge<Vertex> edge : graph.get(current)) {
                Vertex neighbor = edge.getDest();
                double weight = edge.getWeight();
                double altDist = distances.get(current) + weight;

                if (altDist < distances.get(neighbor)) {
                    distances.put(neighbor, altDist);
                    previous.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }

        return distances;
    }
}
