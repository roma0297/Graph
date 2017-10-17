public class Edge {
    private Vertex a;
    private Vertex b;

    public Edge(Vertex a, Vertex b) {
        this.a = a;
        this.b = b;
    }

    public Vertex getA() {
        return a;
    }

    public Vertex getB() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if ((a.equals(edge.a) && b.equals(edge.b)) || (a.equals(edge.b) && b.equals(edge.a))) {
            return true;
        } else {
            return false;
        }

    }

}
