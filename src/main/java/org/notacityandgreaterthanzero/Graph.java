public class Graph {
    public Node[] nodes;

    public static void main(String[] args) {
        Graph test = new Graph();

        GraphNode n1 = new GraphNode();
        n1.name = "Test Node";

        n1.children = new GraphNode[]{};

        //test.nodes[0] = new Node().name;
    }
}

class GraphNode {
    public String name;
    public GraphNode[] children;
}
