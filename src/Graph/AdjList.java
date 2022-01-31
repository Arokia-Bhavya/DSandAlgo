package Graph;

import java.util.LinkedList;

public class AdjList {
	public static void main(String[] args)
	{
		LinkedList[] nodes=new LinkedList[5];
		AdjList adjList=new AdjList();
		adjList.addEdge(nodes,0,1);
		adjList.addEdge(nodes,0,2);
		adjList.addEdge(nodes,0,3);
		adjList.addEdge(nodes,1,3);
		adjList.addEdge(nodes,1,4);
		adjList.addEdge(nodes,2,3);
		adjList.addEdge(nodes,3,4);
		adjList.printGraph(nodes);
	}

	private void printGraph(LinkedList<Integer>[] nodes) {
		for(int src=0;src<nodes.length;src++)
		{
			System.out.println();
			System.out.print(src+"->");
			if(nodes[src]!=null)
			{
				for(Integer dest:nodes[src])
					System.out.print(dest+"->");
			}
				System.out.print("null");			
		}
	}

	private void addEdge(LinkedList[] nodes, int src, int dest) {
		if(nodes[src]==null)
		{
			nodes[src]=new LinkedList<Integer>();
		}
		nodes[src].add(dest);
	}
	
	private void removeEdge(LinkedList[] nodes, int src, int dest) {
		nodes[src].remove(dest);
	}


}
