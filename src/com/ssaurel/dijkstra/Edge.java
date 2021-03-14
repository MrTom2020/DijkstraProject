package com.ssaurel.dijkstra;

public class Edge
{
	private int fromNodeIndex;
	private int toNodeIndex;
	private int lenght;
	
	public Edge(int fromNodeIndex,int toNodeIndex,int lenth)
	{
		this.fromNodeIndex = fromNodeIndex;
		this.toNodeIndex = toNodeIndex;
		this.lenght = lenth;
	}

	public int getFromNodeIndex() {
		return fromNodeIndex;
	}

	public void setFromNodeIndex(int fromNodeIndex) {
		this.fromNodeIndex = fromNodeIndex;
	}

	public int getToNodeIndex() {
		return toNodeIndex;
	}

	public void setToNodeIndex(int toNodeIndex) {
		this.toNodeIndex = toNodeIndex;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}
	public int getNeighbourIndex(int nodeIndex)
	{
		if(this.fromNodeIndex == nodeIndex)
		{
			return this.toNodeIndex;
		}
		else
		{
			return this.fromNodeIndex;
		}
	}
}
