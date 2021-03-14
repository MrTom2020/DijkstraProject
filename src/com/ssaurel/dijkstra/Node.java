package com.ssaurel.dijkstra;

import java.util.ArrayList;

public class Node 
{
	private int distanceFromSource = Integer.MAX_VALUE;
	
	private boolean visited;
	
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public int getDistanceFromSource()
	{
		return distanceFromSource;
	}
	public void setDistanceFromSource(int distanceFromSource)
	{
		this.distanceFromSource =distanceFromSource;
	}
	public boolean isvisited()
	{
		return visited;
	}
	public void setvisited(boolean visited)
	{
		this.visited = visited;
	}
	public ArrayList<Edge> getEdges()
	{
		return edges;
	}
	public void setEdges(ArrayList<Edge> edges)
	{
		this.edges = edges;
	}
}
