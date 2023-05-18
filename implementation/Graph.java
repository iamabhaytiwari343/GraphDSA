package implementation;
import java.util.ArrayList;

public class Graph {
    
    private ArrayList<vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
        this.vertices = new ArrayList<vertex>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }

    public vertex addVertex(String data) {
        vertex newVertex = new vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void addEdge(vertex vertex1, vertex vertex2, Integer weight) {
        if (!this.isWeighted) {
            weight = null;
        }
        vertex1.addEdge(vertex2, weight);
        if (!this.isDirected) {
            vertex2.addEdge(vertex1, weight);
        }
    }

    public void removeEdge(vertex vertex1, vertex vertex2) {
        vertex1.removeEdge(vertex2);
        if (!this.isDirected) {
            vertex2.removeEdge(vertex1);
        }
    }

    public void removeVertex(vertex vertex) {
        this.vertices.remove(vertex);
    }

    public ArrayList<vertex> getVertices() {
		return this.vertices;
	}

	public boolean isWeighted() {
		return this.isWeighted;
	}

	public boolean isDirected() {
		return this.isDirected;
	}

	public vertex getVertexByValue(String value) {
		for(vertex v: this.vertices) { 
			if (v.getData() == value) {
				return v;
			}
		}

		return null;
	}
	
	public void print() {
		for(vertex v: this.vertices) {
			v.print(isWeighted);
		}
	}

	public static void main(String[] args) {
        Graph busNetwork = new Graph(true, false);
        vertex cliftonStation = busNetwork.addVertex("Clifton");
        vertex capeMayStation = busNetwork.addVertex("Cape May");

        busNetwork.addEdge(cliftonStation, capeMayStation, 1000);
        
        busNetwork.print();
	}
}