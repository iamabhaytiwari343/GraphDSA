package implementation;


public class Edge {
    //holds the start vertex
    private vertex start;
    //holds the end vertex
    private vertex end;
    //holds weight of every vertex
    private Integer weight;

    public Edge(vertex startV, vertex endV, Integer inputWeight) {
        this.start = startV;
        this.end = endV;
        this.weight = inputWeight;
    }
    // helper function to get starting vertex for the edge
    public vertex getStart() {
        return this.start;
    }
    // helper function to get ending vertex for the edge
    public vertex getEnd() {
        return this.end;
    }
    // helper function to get weight of the vertex
    public Integer getWeight() {
        return this.weight;
    }
}