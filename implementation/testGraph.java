package implementation;

class TestGraph {
    private Graph testGraph;

    public TestGraph() {
        this.testGraph = new Graph(false, true);
        vertex startNode = testGraph.addVertex("v0.0.0");
        vertex v1 = this.testGraph.addVertex("v1.0.0");
        vertex v2 = this.testGraph.addVertex("v2.0.0");

        vertex v11 = this.testGraph.addVertex("v1.1.0");
        vertex v12 = this.testGraph.addVertex("v1.2.0");
        vertex v21 = this.testGraph.addVertex("v2.1.0");

        vertex v111 = this.testGraph.addVertex("v1.1.1");
        vertex v112 = this.testGraph.addVertex("v1.1.2");
        vertex v121 = this.testGraph.addVertex("v1.2.1");
        vertex v211 = this.testGraph.addVertex("v2.1.1");

        this.testGraph.addEdge(startNode, v1, null);
        this.testGraph.addEdge(startNode, v2, null);

        this.testGraph.addEdge(v1, v11, null);
        this.testGraph.addEdge(v1, v12, null);
        this.testGraph.addEdge(v2, v21, null);

        this.testGraph.addEdge(v11, v111, null);
        this.testGraph.addEdge(v11, v112, null);
        this.testGraph.addEdge(v12, v121, null);
        this.testGraph.addEdge(v21, v211, null);

        // create a cycle
        this.testGraph.addEdge(v211, v2, null);
    }

    public vertex getStartingVertex() {
        return this.testGraph.getVertices().get(0);
    }
}