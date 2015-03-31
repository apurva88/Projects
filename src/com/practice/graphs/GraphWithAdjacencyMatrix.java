package com.practice.graphs;

public class GraphWithAdjacencyMatrix {

	private int N;
	private int E;
	private int[][] adjacencyMatrix;
	private boolean isDirected;

	public GraphWithAdjacencyMatrix(int N, boolean isDirected) {
		this.N = N;
		adjacencyMatrix = new int[N][N];
		this.isDirected = isDirected;

	}

	public void addEdge(int src, int dest) {
		this.adjacencyMatrix[src][dest] = 1;
		if (!isDirected) {
			this.adjacencyMatrix[dest][src] = 1;
		}
		this.E++;
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

	public int[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public void printGraph() {
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {
				System.out.print(adjacencyMatrix[i][j] + " ");

			}
			System.out.println("");
		}

	}

	public static void main(String args[]) {
		GraphWithAdjacencyMatrix myGraph = new GraphWithAdjacencyMatrix(5,
				false);
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
