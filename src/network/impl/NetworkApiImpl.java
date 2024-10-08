package network.impl;

import network.api.NetworkBoundAPI;

public class NetworkApiImpl {
	
	private NetworkBoundAPI networkBoundAPI;

	public NetworkApiImpl(NetworkBoundAPI networkBoundAPI) {
		this.networkBoundAPI = networkBoundAPI; 
	}

	// these should be integers??

	public String getUserInput(String getInput) {
		return "";
	}

	public String getCeOutput(String getOutput) {
		return ""; // call Factorial compute ;
	}
	
		// connect to data store
}
