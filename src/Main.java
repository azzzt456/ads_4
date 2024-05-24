public class Main {
    public static void main(String[] args) {
        WeightedGraph<Vertex<String>> graph = new WeightedGraph<>();

        Vertex<String> v1 = new Vertex<>("A");
        Vertex<String> v2 = new Vertex<>("B");
        Vertex<String> v3 = new Vertex<>("C");

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v1, v2, 1.0);
        graph.addEdge(v1, v3, 4.0);
        graph.addEdge(v2, v3, 2.0);

        BFS<Vertex<String>> bfs = new BFS<>();
        System.out.println("BFS starting from A: " + bfs.bfs(v1, graph.getVertices()));

        DijkstraSearch<Vertex<String>> dijkstra = new DijkstraSearch<>();
        System.out.println("Dijkstra starting from A: " + dijkstra.dijkstra(v1, graph.getVertices()));
    }
}
