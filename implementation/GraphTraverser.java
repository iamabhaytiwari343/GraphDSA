package implementation;

import java.util.ArrayList;

class GraphTraverser {

    public static void depthFirstTraversal(vertex start, ArrayList<vertex> visitedVertices) {
        System.out.println(start.getData());

        for (Edge e : start.getEdges()) {
            vertex neighbor = e.getEnd();

            if (!visitedVertices.contains(neighbor)) {
                visitedVertices.add(neighbor);
                GraphTraverser.depthFirstTraversal(neighbor, visitedVertices);
            }
        }
    }

    public static void breadthFirstSearch(vertex start, ArrayList<vertex> visitedVertices) {
        Queue visitQueue = new Queue();
        visitQueue.enqueue(start);
        while (!visitQueue.isEmpty()) {
            vertex current = visitQueue.dequeue();
            System.out.println(current.getData());

            for (Edge e : current.getEdges()) {
                vertex neighbor = e.getEnd();
                if (!visitedVertices.contains(neighbor)) {
                    visitedVertices.add(neighbor);
                    visitQueue.enqueue(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        TestGraph test = new TestGraph();
        vertex startingVertex = test.getStartingVertex();
        ArrayList<vertex> visitedVertices1 = new ArrayList<vertex>();
        ArrayList<vertex> visitedVertices2 = new ArrayList<vertex>();
        visitedVertices1.add(startingVertex);
        visitedVertices2.add(startingVertex);
        System.out.println("DFS:");
        GraphTraverser.depthFirstTraversal(startingVertex, visitedVertices1);
        System.out.println("BFS:");
        GraphTraverser.breadthFirstSearch(startingVertex, visitedVertices2);
    }
}
