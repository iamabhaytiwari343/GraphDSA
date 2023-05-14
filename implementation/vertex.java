package implementation;

import java.util.*;

public class vertex {
    private String data;
    private ArrayList<Edge> edges;

    public vertex(String inputData){
        this.data=inputData;
        this.edges=new ArrayList<Edge>(null);
    }

    public void addEdge(vertex endVertex, Integer weight) {
        this.edges.add(new Edge(this, endVertex, weight));
    }

    public void removeEdge(vertex endVertex) {
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }

    public String getData() {
        return this.data;
    }
    public ArrayList<Edge> getEdges(){
        return this.edges;
    }

    public static void main(String args[]) {

    }
}
