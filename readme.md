Graph theory concepts and algorithm in JAVA.

this graph implementation uses adjacency list to store the edges(relation between vertex).
weight of the edge is explicitly defined.

# Vertex Class

| function | use|
|---------|-----|
|addEdge | to add edges to a vertex|
|removeEdge| to remove edge from the vertex|
| getData | to get data from the vertex|
| getEdges| to get edges from the vertex |

# Edge Class
used to represent the connections or relationships between vertices (also known as nodes) in a graph. 

# Graph Traversals
Graph traversal refers to the process of systematically visiting or exploring all the vertices (nodes) and edges of a graph. It involves traversing or moving through the graph in a specific order to access and process the graph's elements.

There are two commonly used methods for graph traversal:

    Depth-First Search (DFS): DFS explores a graph by visiting a vertex and then recursively visiting all its adjacent vertices. It goes as deep as possible before backtracking and exploring other branches. DFS uses a stack or recursion to keep track of the vertices to be visited. This approach is useful for exploring paths and finding connected components in a graph.

    Breadth-First Search (BFS): BFS explores a graph by visiting a vertex and then visiting all its neighboring vertices before moving on to the next level of vertices. It starts from the initial vertex and systematically visits vertices in increasing distance from the source. BFS uses a queue to store the vertices to be visited. This approach is useful for finding the shortest path between two vertices, determining connectivity, or exploring all vertices at a certain distance from the source.

Both DFS and BFS can be applied to both directed and undirected graphs. They can be implemented using various data structures and algorithms, depending on the specific requirements and characteristics of the graph.

Graph traversal algorithms are widely used in various applications, such as pathfinding, network analysis, social network analysis, web crawling, and data mining. These algorithms provide a foundation for solving graph-related problems and extracting meaningful information from complex networks.

# BFS 
 Breadth-First Search (BFS) is a graph traversal algorithm that systematically explores the vertices of a graph in breadth-first order. It starts at a given source vertex and visits all its neighboring vertices before moving on to the next level of vertices.

Here's how the BFS algorithm works:

    Choose a source vertex to start the traversal.
    Enqueue the source vertex into a queue data structure.
    Mark the source vertex as visited.
    While the queue is not empty:
        Dequeue a vertex from the front of the queue.
        Process the dequeued vertex (e.g., print it or perform some operation).
        Enqueue all the unvisited neighboring vertices of the dequeued vertex into the queue and mark them as visited.
    Repeat steps 4 until the queue becomes empty.

BFS visits the vertices of a graph in layers, exploring all the vertices at the current level before moving on to the next level. This guarantees that BFS visits vertices in increasing distance from the source vertex.

BFS can be used for various purposes, such as finding the shortest path between two vertices, determining connectivity or reachability, identifying connected components, and checking bipartiteness of a graph.

The time complexity of BFS is O(V + E), where V represents the number of vertices and E represents the number of edges in the graph. The space complexity is also O(V) as the queue may store all the vertices at a particular level.

BFS is typically implemented using a queue data structure, which follows the First-In-First-Out (FIFO) principle. This ensures that vertices are visited in the order they were added to the queue, mimicking the breadth-first exploration of the graph.

# DFS

Depth-First Search (DFS) is a graph traversal algorithm that explores as far as possible along each branch before backtracking. It systematically visits the vertices of a graph in depth-first order.

Here's how the DFS algorithm works:

    Choose a source vertex to start the traversal.
    Mark the source vertex as visited.
    Process the visited vertex (e.g., print it or perform some operation).
    Recursively visit all the unvisited neighboring vertices of the current vertex.
    Repeat step 4 for each unvisited neighboring vertex, following a specific order (e.g., based on the order they appear in the adjacency list or based on a specific priority).

DFS effectively explores a path as deep as possible before backtracking and exploring other branches. It uses a stack (either an actual stack data structure or the call stack in a recursive implementation) to keep track of the vertices to be visited.

DFS can be used for various purposes, such as finding paths between two vertices, checking connectivity, detecting cycles, and performing topological sorting.

There are two common variations of DFS:

    Recursive DFS: In the recursive implementation, DFS is achieved by using function calls and the call stack to manage the traversal. It starts with the source vertex and recursively explores each unvisited neighbor, backtracking when necessary.

    Iterative DFS: In the iterative implementation, a stack data structure is used explicitly to manage the traversal. The algorithm starts with the source vertex, pushes it onto the stack, and iteratively visits and explores vertices until the stack becomes empty.

The time complexity of DFS is O(V + E), where V represents the number of vertices and E represents the number of edges in the graph. The space complexity is O(V) in the worst case, considering the stack or recursion depth.

DFS is often used when exploring paths or searching for solutions in a graph, as it can be more memory-efficient than BFS. However, it may not guarantee the shortest path between two vertices unless additional conditions or modifications are applied.


```
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

```
```
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

```
