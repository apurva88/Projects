package com.practice.graphs;

public class DetectCycle {

	public static void main(String[] args) {
		// create graph
		GraphWithAdjacencyMatrix g = new GraphWithAdjacencyMatrix(5, true);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		// myGraph.printGraph();

		System.out.println(detectCycle(g));
	}

	public static boolean detectCycle(GraphWithAdjacencyMatrix g) {
		boolean visited[] = new boolean[g.getN()];
		boolean recStack[] = new boolean[g.getN()];
		for (int i = 0; i < g.getN(); i++) {
			if (detectCycleUtil(g, i, visited, recStack)) {
				return true;
			}
		}
		return false;
	}

	public static boolean detectCycleUtil(GraphWithAdjacencyMatrix g,
			int source, boolean[] visited, boolean[] recStack) {
		if (visited[source] == false) {
			visited[source] = true;
			recStack[source] = true;
			for (int i = 0; i < g.getAdjacencyMatrix().length; i++) {
				if (g.getAdjacencyMatrix()[source][i] == 1 && !visited[i]
						&& detectCycleUtil(g, i, visited, recStack)) {
					return true;
				} else if (g.getAdjacencyMatrix()[source][i] == 1 && recStack[i] == true) {
					System.out.println("Cycle!!");
					return true;

				}
			}
		}
		recStack[source] = false;
		return false;
	}
}
