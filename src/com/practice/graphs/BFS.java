package com.practice.graphs;

import java.util.LinkedList;

public class BFS {

	// Breadth First Search of a Graph

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

		bfs(g, 2);
	}

	public static void bfs(GraphWithAdjacencyMatrix graph, int source) {

		boolean visited[] = new boolean[graph.getN()];
		LinkedList<Integer> q = new LinkedList<Integer>();
		int[][] neighborArray = graph.getAdjacencyMatrix();

		visited[source] = true;
		q.addLast(source);
		while (!q.isEmpty()) {
			int value = q.poll();
			System.out.println(value + " ");
			// find neighbors
			for (int j = 0; j < neighborArray.length; j++) {
				int neighbor = neighborArray[value][j];
				if (neighbor == 1 && visited[j] != true) {
					visited[j] = true;
					q.addLast(j);
				}
			}
		}
	}

}
