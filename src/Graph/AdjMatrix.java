package Graph;

public class AdjMatrix {
	
	public static void main(String[] args)
	{
		int[][] nodes=new int[5][5];
		AdjMatrix adjmatrix=new AdjMatrix();
		adjmatrix.addEdge(nodes,0,1);
		adjmatrix.addEdge(nodes,0,2);
		adjmatrix.addEdge(nodes,0,3);
		adjmatrix.addEdge(nodes,1,3);
		adjmatrix.addEdge(nodes,1,4);
		adjmatrix.addEdge(nodes,2,3);
		adjmatrix.addEdge(nodes,3,4);
		adjmatrix.printGraph(nodes);
	}

	private void printGraph(int[][] nodes) {
		for(int[] row:nodes)
		{
			System.out.println();
			for(int col:row)
			{
				System.out.print(col+" ");
			}
		}
			
	}

	private void addEdge(int[][] nodes, int src, int dest) {
		nodes[src][dest]=1;
	}

	private void removeEdge(int[][] nodes, int src, int dest) {
		nodes[src][dest]=0;
	}
	
	private boolean hasEdge(int[][] nodes, int src, int dest)
	{
		return nodes[src][dest]==1;
	}
}
