package com.practice.graphs;

import java.util.Stack;

public class DFS {

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

		boolean visited[] = new boolean[g.getN()];
		// dfs(g, 2, visited);
		// System.out.println("\n\n");
		dfsNonRecursive(g, 2);
	}

	public static void dfs(GraphWithAdjacencyMatrix g, int vertex,
			boolean[] visited) {
		System.out.println(vertex);
		visited[vertex] = true;
		for (int i = 0; i < g.getN(); i++) {
			if (g.getAdjacencyMatrix()[vertex][i] == 1 && !visited[i]) {
				dfs(g, i, visited);
			}

		}

	}

	public static void dfsNonRecursive(GraphWithAdjacencyMatrix g, int vertex) {
		boolean[] visited = new boolean[g.getN()];

		Stack<Integer> dfsStack = new Stack<Integer>();
		int[][] neighborArray = g.getAdjacencyMatrix();
		visited[vertex] = true;
		dfsStack.push(vertex);
		while (!dfsStack.isEmpty()) {
			int value = dfsStack.pop();
			System.out.println(value);
			// find neighbors
			for (int j = 0; j < neighborArray.length; j++) {
				int neighbor = neighborArray[value][j];
				if (neighbor == 1 && visited[j] != true) {
					visited[j] = true;
					dfsStack.push(j);
				}
			}

		}
	}
}
