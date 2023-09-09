import java.util.ArrayList;
import java.util.List;

public class Graph {
    ArrayList<Vertex> vertices;


    public Graph() {
        vertices = new ArrayList<>();
    }

    public boolean hasVertex(Vertex v) {
        if (vertices.contains(v)) {
            return true;
        } else {
            return false;
        }
    }

    public List<Vertex> getVertices() {
        return vertices;
    }


    public void addVertex(Vertex v) {
        for (int i = 0; i < vertices.size(); i++) {
            if(vertices.get(i).value.equals(v.value)) {
                throw new IllegalArgumentException();
            }
        }
        vertices.add(v);
    }


    public Vertex getVertex(String name) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).value.equals(name)) {
                return vertices.get(i);
            }
        }
        return null;
    }


    public void addEdge(String start, String dest, Double cost) {
        Vertex startvalue = getVertex(start);
        Vertex destvalue = getVertex(dest);
        if (startvalue != null) {
            if (destvalue != null) {
                Edge edge = new Edge(cost, startvalue, destvalue);
                startvalue.addEdge(edge);
            }
        }
    }


    public void addUndirectedEdge(String start, String dest, Double cost) {
        Vertex startvalue = getVertex(start);
        Vertex destvalue = getVertex(dest);
        if (startvalue!= null) {
            if (destvalue != null) {
                Edge edge = new Edge(cost, startvalue, destvalue);
                startvalue.addEdge(edge);
                Edge edge2 = new Edge(cost, destvalue, startvalue);
                destvalue.addEdge(edge2);
            }
        }


    }


    public int findClosestVertex(List<Vertex> list) {
        double yes = Double.MAX_VALUE;
        int lowindex = 0;
        for (int i = 0; i < list.size(); i++) {
            Vertex starting = list.get(i);
            if (yes > starting.distance) {
                if (!starting.hasVisited) {
                    yes = starting.distance;
                    lowindex = i;
                }
            }

        }

        return lowindex;
    }


    public void dijkstra(String s) {

        for (int i = 0; i < vertices.size(); i++) {
            Vertex Joe = vertices.get(i);
            Joe.distance = Double.MAX_VALUE;
            Joe.hasVisited = false;
            Joe.initial = null;
        }

        Vertex starting = getVertex(s);
        starting.distance = 0;
        starting.initial = null;

        for (int i = 0; i < this.vertices.size(); i++) {
            for (int j = 0; j < starting.neighbors.size(); j++) {

                Edge route = starting.neighbors.get(j);
                Vertex destValue = route.dest;

                if (!destValue.hasVisited) {
                    if (destValue.distance > route.weight + starting.distance) {
                        destValue.distance = route.weight;
                        destValue.distance += starting.distance;
                        destValue.initial = starting;
                    }

                }
            }

            starting.hasVisited = true;
            int index = findClosestVertex(this.vertices);
            starting = this.vertices.get(index);

        }


    }


    public List<Edge> getDijkstraPath(String start, String dest) {
        dijkstra(start);

        List<Edge> Dijkstra = new ArrayList<>();

        Vertex Joey = getVertex(dest);
        while (Joey != null) {
            for (int i = 0; i < Joey.neighbors.size(); i++) {
                Edge one = Joey.neighbors.get(i);
                Vertex Rose = one.dest;

                if (Joey.initial == Rose) {
                    Dijkstra.add(one);
                }
            }

            Joey = Joey.initial;

        }


        return Dijkstra;
        }



        public void printGraph() {
            for (int j = 0; j < vertices.size(); j++) {
                String output = getVertex(vertices.get(j).value) + ": ";
                Vertex this_vert = vertices.get(j);
                for (int i = 0; i < this_vert.neighbors.size(); i++) {
                    output += "(" + this_vert.value + " - " + this_vert.neighbors.get(i) + ")";
                }

                System.out.println(output);
            }
        }



}


