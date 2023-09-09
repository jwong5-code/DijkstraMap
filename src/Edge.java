public class Edge {
    double weight;
    Vertex source;
    Vertex dest;



    public Edge(double weight, Vertex point, Vertex destination) {
        this.weight = weight;
        this.source = point;
        this.dest = destination;

    }

    public String toString() {
        return "(" + source + " - " + dest + ")";
    }


}
