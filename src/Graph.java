import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by roman on 01.10.17.
 */
public class Graph implements IGraph {
    Set<Vertex> vertexList;
    List<Edge> edgeList;

    public Graph(Set<Vertex> vertexList, List<Edge> edgeList) {
        this.vertexList = vertexList;
        this.edgeList = edgeList;
    }

    public Graph(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    public long degreeOfVertex(Vertex vertex) {
        return edgeList.parallelStream().filter(o -> (o.getA().equals(vertex) || o.getB().equals(vertex))).count();
    }

    public long maxDegree() {
        long max = 0;

        for (Vertex vertex : vertexList) {
            max = Math.max(degreeOfVertex(vertex), max);
        }

        return max;
    }

    public double averageDegree() {
        long sumDegree = 0;

        for (Vertex vertex : vertexList) {
            sumDegree += degreeOfVertex(vertex);
        }

        return (double) sumDegree / vertexList.size();
    }

    public void addEdge(Edge edge) {
        edgeList.add(edge);
    }

    public void deleteEdge(Edge edge) {
        Edge edgeToDelete = edgeList.stream().filter(o -> o.equals(edge)).findFirst().get();

        edgeList.remove(edgeToDelete);
    }

    public void addVertex(Vertex vertex) {
        vertexList.add(vertex);
    }

    public void deleteVertex(Vertex vertex) {
        Vertex vertexToDelete = vertexList.stream().filter(o -> o.equals(vertex)).findFirst().get();

        vertexList.remove(vertexToDelete);

        edgeList.removeIf(edge -> edge.getA().equals(vertexToDelete) || edge.getB().equals(vertexToDelete));
    }

    public List<Edge> findSelfLoops() {
        return edgeList.stream().filter(o -> o.getA().equals(o.getB())).collect(Collectors.toList());
    }
}


class TestGraph {
    public static void main(String[] args) {
        Vertex vertex0 = new Vertex(0);
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);

        Set<Vertex> vertices = new HashSet<>();
        vertices.add(vertex0);
        vertices.add(vertex1);
        vertices.add(vertex2);
        vertices.add(vertex3);

        List<Edge> edges = new ArrayList<>(Arrays.asList(
                new Edge(vertex0, vertex1),
                new Edge(vertex0, vertex1),
                new Edge(vertex0, vertex0),
                new Edge(vertex1, vertex2)));


        Graph graph = new Graph(vertices, edges);

        System.out.println("Max degree: " + graph.maxDegree());
        System.out.println("Average degree: " + graph.averageDegree());
        System.out.println("Degree of vertex0: " + graph.degreeOfVertex(vertex0));
        System.out.println("Degree of vertex2: " + graph.degreeOfVertex(vertex2));


    }
}

