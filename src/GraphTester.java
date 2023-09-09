public class GraphTester {


    public static void main(String[] args) {
        Graph tester = new Graph();
        tester.addVertex(new Vertex("AA"));
        System.out.println(tester.getVertices());
        tester.addVertex(new Vertex("BB"));
        tester.addVertex(new Vertex("CC"));
        tester.addVertex(new Vertex("DD"));
        tester.addVertex(new Vertex("EE"));
        tester.addVertex(new Vertex("FF"));
        tester.addVertex(new Vertex("GG"));
        tester.addVertex(new Vertex("HH"));
        Vertex Hi = new Vertex("Hi");
        try {
            tester.addVertex(new Vertex("AA"));
        } catch (IllegalArgumentException exception) {
            System.out.println("illegal"); //should print out illegal
        }
        System.out.println(tester.getVertices()); //[AA, BB, CC, DD, EE, FF, GG, HH]

        tester.addEdge("AA", "BB", 100.90);
        System.out.println(tester.getVertex("AA").neighbors);//[(AA - BB)]
        tester.addUndirectedEdge("AA", "BB", 102020.0);
        // Duplicate paths allowed since there is another path connecting two vertices that is faster than the other
        System.out.println(tester.getVertex("AA").neighbors);//[(AA - BB), (AA - BB)]
        System.out.println(tester.getVertex("BB").neighbors); //[(BB - AA)]
        tester.addUndirectedEdge("ZZ", "AA", 1.0);
        System.out.println(tester.getVertex("ZZ")); //null
        System.out.println(tester.findClosestVertex(tester.getVertices())); //0
        System.out.println(tester.hasVertex(Hi)); //false as it is not in graph
        System.out.println(tester.hasVertex(tester.getVertex("AA"))); //true

        tester.printGraph(); //prints every vertex

    }

}
