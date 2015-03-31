package com.practice.graphs;

public class DetectCycleUndirectedGraph {

	public static void main(String[] args) {
		// create graph
		GraphWithAdjacencyMatrix g1 = new GraphWithAdjacencyMatrix(5, false);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);

		// myGraph.printGraph();

		System.out.println(detectCycle(g1));
	}

	public static boolean detectCycle(GraphWithAdjacencyMatrix g) {
		boolean visited[] = new boolean[g.getN()];
		for (int i = 0; i < g.getN(); i++) {
			if (!visited[i]) {
				if (detectCycleUtil(g, i, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean detectCycleUtil(GraphWithAdjacencyMatrix g,
			int source, boolean[] visited, int parent) {
		visited[source] = true;
		for (int i = 0; i < g.getAdjacencyMatrix().length; i++) {
			if (g.getAdjacencyMatrix()[source][i] == 1 && !visited[i]) {
				if (detectCycleUtil(g, i, visited, source)) {
					return true;
				}

			} else if (g.getAdjacencyMatrix()[source][i] == 1 && i != parent) {
				System.out.println("Cycle!!");
				return true;

			}
		}

		return false;
	}
}
