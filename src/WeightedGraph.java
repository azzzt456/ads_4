public class WeightedGraph<V> extends MyGraph<V> {
    public WeightedGraph(boolean undirected) {
        super(undirected);
    }

    public void addEdge(V source, V dest, double weight) {
        Vertex<V> sourceV = map.get(source);
        Vertex<V> destV = map.get(dest);
        if (sourceV == null) {
            sourceV = new Vertex<>(source);
            addVertex(source, sourceV);
        }
        if (destV == null) {
            destV = new Vertex<>(dest);
            addVertex(dest, destV);
        }
        sourceV.addAdjacentVertices(destV, weight);
        if (undirected) {
            destV.addAdjacentVertices(sourceV, weight);
        }
    }
}
