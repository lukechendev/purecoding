package lchen.datastructure.graphsearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

    private Node getNode(int id) {
        return nodeLookup.get(id);
    }

    public void addEdge(int source, int destination) {
        Node sourceNode = getNode(source);
        if (sourceNode == null) {
            sourceNode = new Node(source);
            nodeLookup.put(source, sourceNode);
        }

        Node destNode = getNode(destination);
        if (destNode == null) {
            destNode = new Node(destination);
            nodeLookup.put(destination, destNode);
        }

        if (!sourceNode.adjs.contains(destNode)) {
            sourceNode.adjs.push(destNode);
        }

        if (!destNode.adjs.contains(sourceNode)) {
            destNode.adjs.push(sourceNode);
        }
    }

    public boolean hasPathDFS(int source, int destination) {
        Node sourceNode = getNode(source);
        Node destNode = getNode(destination);

        HashSet<Integer> visited = new HashSet<Integer>();

        return hasPathDFS(sourceNode, destNode, visited);
    }

    private boolean hasPathDFS(Node sourceNode, Node destNode, HashSet<Integer> visited) {
        if (sourceNode == null || destNode == null) {
            return false;
        }

        if (visited.contains(sourceNode.id)) {
            return false;
        }

        visited.add(sourceNode.id);

        if (sourceNode.id == destNode.id) {
            return true;
        }

        Iterator<Node> sourceIter = sourceNode.adjs.iterator();
        while (sourceIter.hasNext()) {
            if (hasPathDFS(sourceIter.next(), destNode, visited)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasPathBFS(int source, int destination) {
        Node sourceNode = getNode(source);
        Node destNode = getNode(destination);

        return hasPathBFS(sourceNode, destNode);
    }

    private boolean hasPathBFS(Node sourceNode, Node destNode) {
        if (sourceNode == null || destNode == null) {
            return false;
        }

        LinkedList<Node> toVisit = new LinkedList<Node>();
        HashSet<Integer> visited = new HashSet<Integer>();

        toVisit.add(sourceNode);
        visited.add(sourceNode.id);
        while (!toVisit.isEmpty()) {
            Node cur = toVisit.poll();
            if (cur != null) {
                if (cur.id == destNode.id) {
                    return true;
                }

                Iterator<Node> children = cur.adjs.iterator();
                while (children.hasNext()) {
                    Node child = children.next();
                    if (child != null && !visited.contains(child.id)) {
                        toVisit.add(child);
                        visited.add(child.id);
                    }
                }
            }
        }

        return false;
    }

    private static class Node {
        int id;
        LinkedList<Node> adjs = new LinkedList<Node>();

        Node(int id) {
            this.id = id;
        }

        public boolean equals(Object obj) {
            if (obj != null && obj instanceof Node && ((Node) obj).id == this.id) {
                return true;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        int numNodes = 14;

        // cluster 1
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 6);
        g.addEdge(2, 3);
        g.addEdge(3, 6);
        g.addEdge(4, 6);
        g.addEdge(5, 6);
        g.addEdge(6, 9);
        g.addEdge(9, 7);

        // cluster 2
        g.addEdge(8, 10);
        g.addEdge(10, 11);
        g.addEdge(10, 14);
        g.addEdge(11, 13);
        g.addEdge(13, 12);
        g.addEdge(12, 8);

        System.out.println("DFS: The graph has path from 1 to:");
        for (int i = 1; i <= numNodes; ++i) {
            System.out.println(i + ": " + g.hasPathDFS(1, i));
        }

        System.out.println("DFS: The graph has path from 8 to:");
        for (int i = 1; i <= numNodes; ++i) {
            System.out.println(i + ": " + g.hasPathDFS(8, i));
        }

        System.out.println("BFS: The graph has path from 1 to:");
        for (int i = 1; i <= numNodes; ++i) {
            System.out.println(i + ": " + g.hasPathBFS(1, i));
        }

        System.out.println("BFS: The graph has path from 8 to:");
        for (int i = 1; i <= numNodes; ++i) {
            System.out.println(i + ": " + g.hasPathBFS(8, i));
        }
    }
}
