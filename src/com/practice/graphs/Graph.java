package com.practice.graphs;

public class Graph {

	private class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}

	// Number of vertices
	private int N;
	private int E;
	private Node[] adjacencyList;
	private boolean isDirected;

	private void initGraph(int N) {
		// set number of nodes
		this.N = N;
		adjacencyList = new Node[N];
		for (int i = 0; i < N; i++) {
			adjacencyList[i] = new Node(i);
		}

	}

	public Graph(int N, boolean isDirected) {
		initGraph(N);
		this.isDirected = isDirected;
	}

	public void addEdge(int src, int dest) {

		// Create new Node for the dest
		Node destination = new Node(dest);

		// get the adjacency list for src
		Node srcList = adjacencyList[src].next;

		// Attach destination to beginning of srcList
		destination.next = srcList;

		// re-assign srcList pointer
		adjacencyList[src].next = destination;

		if (!isDirected) {
			// get list for dest
			Node source = new Node(src);
			Node destList = adjacencyList[dest].next;
			// Attach destination to beginning of srcList
			source.next = destList;

			// re-assign srcList pointer
			adjacencyList[dest].next = source;
		}
		this.E++;

	}

	public void printGraph() {
		for (int i = 0; i < N; i++) {
			System.out.print(i + "-> ");
			Node list = adjacencyList[i].next;
			while (list != null) {
				if (list.next != null) {
					System.out.print(list.value + "-> ");
				} else {
					System.out.print(list.value);
				}
				list = list.next;
			}
			System.out.println(" ");
		}
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}

	public int getE() {
		return E;
	}

	public void setE(int e) {
		E = e;
	}

	public Node[] getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(Node[] adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public static void main(String args[]) {
		Graph myGraph = new Graph(5, false);
		myGraph.addEdge(0, 1);
		myGraph.addEdge(0, 4);
		myGraph.addEdge(4, 1);
		myGraph.addEdge(3, 1);
		myGraph.addEdge(4, 3);
		myGraph.addEdge(2, 1);
		myGraph.addEdge(3, 2);

		myGraph.printGraph();
		System.out.println("Number of Edges: " + myGraph.E);
	}
}
