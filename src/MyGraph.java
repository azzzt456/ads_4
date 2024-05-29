import java.util.HashMap;
import java.util.Map;

public class MyGraph<V> {
    protected boolean undirected;
    protected Map<V, Vertex<V>> map;

    public MyGraph(boolean undirected) {
        this.map = new HashMap<>();
        this.undirected = undirected;
    }

    public void addVertex(V data) {
        map.put(data, new Vertex<>(data));
    }

    public void addVertex(V data, Vertex<V> vertex) {
        map.put(data, vertex);
    }

    public void addEdge(V source, V dest) {
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
        sourceV.addAdjacentVertices(destV, 0);
        if (undirected) {
            destV.addAdjacentVertices(sourceV, 0);
        }
    }

    public Vertex<V> getVertex(V data) {
        return map.get(data);
    }
}
