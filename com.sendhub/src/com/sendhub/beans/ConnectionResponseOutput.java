package com.sendhub.beans;

import java.util.List;

//This is the class that holds the final object which is converted to json and sent as the output.

public class ConnectionResponseOutput {
	String message;
	List<Route> routes;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = (routes);
	}

	@Override
	public String toString() {
		return "ConnectionResponseOutput [message=" + message + ", routes="
				+ routes + "]";
	}

}
