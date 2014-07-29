package com.mypractice.org.Graph;

public class NodeVertex {

	
	private String nodeName;
	private NeighborInfo neighborInfo;
	
	
	
	
	
	public NodeVertex(String nodeName, NeighborInfo neighborInfo) {
		super();
		this.nodeName = nodeName;
		this.neighborInfo = neighborInfo;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public NeighborInfo getNeighborInfo() {
		return neighborInfo;
	}
	public void setNeighborInfo(NeighborInfo neighborInfo) {
		this.neighborInfo = neighborInfo;
	}
	
	
	
	
	
}
