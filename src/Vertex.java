import java.util.ArrayList;

public class Vertex {
    String value;
    double distance;
    boolean hasVisited;
    ArrayList<String> adjacent;
    ArrayList<Edge> neighbors;
    int x;
    int y;
    Vertex initial;
   // Vertex point;

    public Vertex(String value) {
        this.distance = 0;
        this.hasVisited = false;
        this.x = 0;
        this.y = 0;
        this.value = value;
        this.adjacent = new ArrayList<>();
        this.neighbors = new ArrayList<>();

    }
    public Vertex(String value, int x, int y) {
        this.distance = 0;
        this.hasVisited = false;
        this.adjacent = new ArrayList<>();
        this.value = value;
        this.x = x;
        this.y = y;
        this.initial = null;
        this.neighbors = new ArrayList<>();

    }

    public void addEdge(Edge e) {
        this.neighbors.add(e);
    }

    public String toString()  {
        return value;
    }

}
