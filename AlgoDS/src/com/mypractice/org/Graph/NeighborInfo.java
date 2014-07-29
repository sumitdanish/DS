/**
 * 
 */
package com.mypractice.org.Graph;

/**
 * @author SUMMITM
 *
 */
public class NeighborInfo {

	private int nodeNumber;
	private NeighborInfo neighborInfoNext;
	public int getNodeNumber() {
		return nodeNumber;
	}
	public void setNodeNumber(int nodeNumber) {
		this.nodeNumber = nodeNumber;
	}
	public NeighborInfo getNeighborInfoNext() {
		return neighborInfoNext;
	}
	public void setNeighborInfoNext(NeighborInfo neighborInfoNext) {
		this.neighborInfoNext = neighborInfoNext;
	}
	public NeighborInfo(int nodeNumber, NeighborInfo neighborInfoNext) {
		super();
		this.nodeNumber = nodeNumber;
		this.neighborInfoNext = neighborInfoNext;
	}
	
	
	
	
}
