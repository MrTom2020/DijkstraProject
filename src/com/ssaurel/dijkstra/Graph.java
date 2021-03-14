package com.ssaurel.dijkstra;

import java.util.ArrayList;

public class Graph 
{
	private Node[] nodes;
	private int noOfNodes;
	private Edge[] edges;
	private int noOfEdges;
	public Graph(Edge[] edges)
	{
		this.edges = edges;
		
		this.noOfNodes = calulateNoOfNodes(edges);
		this.nodes = new Node[this.noOfNodes];
		
		for(int n = 0; n < this.noOfNodes;n++)
		{
			this.nodes[n] = new Node();
		}
		this.noOfEdges = edges.length;
		for(int edgeToApp = 0;edgeToApp < this.noOfEdges;edgeToApp++)
		{
			this.nodes[edges[edgeToApp].getFromNodeIndex()].getEdges().add(edges[edgeToApp]);
			this.nodes[edges[edgeToApp].getToNodeIndex()].getEdges().add(edges[edgeToApp]);
		}
	}
	private int calulateNoOfNodes(Edge[] edges)
	{
		int noOfNodes = 0;
		for(Edge e : edges)
		{
			if(e.getToNodeIndex() > noOfNodes)
			{
				noOfNodes = e.getToNodeIndex();
			}
			if(e.getFromNodeIndex() > noOfNodes)
			{
				noOfNodes = e.getFromNodeIndex();
			}
		}
		noOfNodes++;
		// TODO Auto-generated method stub
		return noOfNodes;
	}
	public void calulateShortestDistances()
	{
		this.nodes[0].setDistanceFromSource(0);
		int nextNode = 0;
		for(int i =0; i < this.nodes.length;i++)
		{
			ArrayList<Edge> currentNodeEdges   = this.nodes[nextNode].getEdges();
			for(int joinetEdge = 0;joinetEdge <  currentNodeEdges.size();joinetEdge++)
			{
				int neighbourIndex = currentNodeEdges.get(joinetEdge).getNeighbourIndex(joinetEdge);
				if(!this.nodes[neighbourIndex].isvisited())
				{
					int tentaitive = this.nodes[nextNode].getDistanceFromSource() + currentNodeEdges.get(joinetEdge).getLenght();
					if(tentaitive < nodes[neighbourIndex].getDistanceFromSource())
					{
						nodes[neighbourIndex].setDistanceFromSource(tentaitive);
					}
				}
				
			}
			nodes[nextNode].setvisited(true);
			nextNode = getNodeShortesDistance();
		}
	}
	private int getNodeShortesDistance() 
	{
		int storeNodeIndex = 0;
		int storeDist = Integer.MAX_VALUE;
		for(int i = 0;i < this.nodes.length;i++)
		{
			int currentDist = this.nodes[i].getDistanceFromSource();
			if(!this.nodes[i].isvisited() && currentDist < storeDist)
			{
				storeDist = currentDist;
				storeNodeIndex = i;
			}
		}
		return storeNodeIndex;
	}
	public void printResult()
	{
		String output = "Number of nodes = " + this.noOfNodes;
		output+= "\nNumber of edges = " + this.noOfEdges;
		for(int i = 0; i < this.nodes.length;i++)
		{
			output+=("\nThe shortest distance from node 0 to node " + i + " is " + nodes[i].getDistanceFromSource()) + " ";
		}
		System.out.print(output);
	}
	public Node[] getNodes() {
		return nodes;
	}
	public int getNo0fNoes() {
		return noOfNodes;
	}
	public Edge[] getEdges() {
		return edges;
	}
	public int getNoOfEdges() {
		return noOfEdges;
	}
}
