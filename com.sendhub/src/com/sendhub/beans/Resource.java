package com.sendhub.beans;

//Class for a resource object
public class Resource {
	String capacity;
	String relaySubnet;
	int throughput;
	int cost;
	int maxHosts;
	double costPerRequest;

	public int getMaxHosts() {
		return maxHosts;
	}

	public void setMaxHosts(int maxHosts) {
		this.maxHosts = maxHosts;
	}

	public double getCostPerRequest() {
		return costPerRequest;
	}

	public void setCostPerRequest(double costPerRequest) {
		this.costPerRequest = costPerRequest;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getRelaySubnet() {
		return relaySubnet;
	}

	public void setRelaySubnet(String relaySubnet) {
		this.relaySubnet = relaySubnet;
	}

	@Override
	public String toString() {
		return "Resource [capacity=" + capacity + ", relaySubnet="
				+ relaySubnet + ", throughput=" + throughput + ", cost=" + cost
				+ ", maxHosts=" + maxHosts + ", costPerRequest="
				+ costPerRequest + "]";
	}

	public int getThroughput() {
		return throughput;
	}

	public void setThroughput(int throughput) {
		this.throughput = throughput;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
