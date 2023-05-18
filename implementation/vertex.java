package implementation;
import java.util.ArrayList;

public class vertex {
    //variable hold data for the vertex 
    private String name;
    // holds the list of adjacent edges to tthe vertex
    private ArrayList<Edge> edges;
    //default constructor to create a vertex
    public vertex(String inputData) {
        this.name = inputData;
        this.edges = new ArrayList<Edge>();
    }
    // function to add edge to a vertex
    public void addEdge(vertex endVertex, Integer weight) {
        this.edges.add(new Edge(this, endVertex, weight));
    }
    // function to remove an edge from the vertex
    public void removeEdge(vertex endVertex) {
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }
    // function for getting the value of the data at vertex
    public String getData() {
        return this.name;
    }
    //function to get all adjacent edges to a vertex
    public ArrayList<Edge> getEdges() {
        return this.edges;
    }
    // function to print the edge weights alongside the vertex and edge data
    public void print(boolean showWeight) {
        String message = "";

        if (this.edges.size() == 0) {
            System.out.println(this.name + " -->");
            return;
        }

        for (int i = 0; i < this.edges.size(); i++) {
            if (i == 0) {
                message += this.edges.get(i).getStart().name + " -->  ";
            }

            message += this.edges.get(i).getEnd().name;

            if (showWeight) {
                message += " (" + this.edges.get(i).getWeight() + ")";
            }

            if (i != this.edges.size() - 1) {
                message += ", ";
            }
        }
        System.out.println(message);
    }
}