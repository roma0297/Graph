import java.util.List;

/**
 * Created by roman on 17.10.17.
 */
public interface IGraph {
    long degreeOfVertex(Vertex vertex);

    long maxDegree();

    double averageDegree();

    void addEdge(Edge edge);

    void deleteEdge(Edge edge);

    void addVertex(Vertex vertex);

    void deleteVertex(Vertex vertex);

    List<Edge> findSelfLoops();
}
