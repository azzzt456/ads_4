public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "New York");
        outputPath(djk, "Los Angeles");

        System.out.println("--------------------------------");

        MyGraph<String> graph = new MyGraph<>(true);
        fillWithoutWeights(graph);

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "New York");
        outputPath(bfs, "Los Angeles");
    }

    public static void fillWithoutWeights(MyGraph<String> graph) {
        graph.addEdge("New York", "Chicago");
        graph.addEdge("Chicago", "Denver");
        graph.addEdge("Denver", "Los Angeles");
        graph.addEdge("New York", "Atlanta");
        graph.addEdge("Atlanta", "Chicago");
        graph.addEdge("Atlanta", "Los Angeles");
        graph.addEdge("Denver", "Seattle");
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("New York", "Chicago", 7.5);
        graph.addEdge("Chicago", "Denver", 5.0);
        graph.addEdge("Denver", "Los Angeles", 8.0);
        graph.addEdge("New York", "Atlanta", 9.0);
        graph.addEdge("Atlanta", "Chicago", 6.5);
        graph.addEdge("Atlanta", "Los Angeles", 12.0);
        graph.addEdge("Denver", "Seattle", 4.0);
    }

    public static void outputPath(Search<String> search, String key) {
        Iterable<String> path = search.pathTo(key);
        if (path == null) {
            System.out.println("No path found to " + key);
        } else {
            for (String v : path) {
                System.out.print(v + " -> ");
            }
            System.out.println();
        }
    }
}
