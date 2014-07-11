/**
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 **/
package it.qvc.http_mock;

import java.io.File;
import java.io.IOException;
import java.util.Properties;



public class BrightcoveMockServer extends NanoHTTPD {

	public BrightcoveMockServer(int port) throws IOException {
		super(port, new File("."));
	}
	
	public Response serve(String uri, String method, Properties header, Properties params, Properties file){
		String msg = "";
		
//		String msg = "{\"id\": 3647705309001,\"videos\": [{ \"id\": 3657883831001, \"itemState\": \"ACTIVE\" }]}";
		if (("POST").equals(method)) {
			msg = uri + " " + params;
		}
		else {
			msg = uri + " " + method +  " " + params;
		}
		
		return new NanoHTTPD.Response(HTTP_OK, MIME_PLAINTEXT, msg);		
	}
	
	public static void main(String[] args) {
		System.out.println("Running...");
		
		try {
			new BrightcoveMockServer(8090);
		} catch(IOException ioe) {
			System.err.print("Couldn't start the server:\n" + ioe);
			System.exit(-1);
		}
		
		System.out.println("Listening on port 8081, Hit Enter to stop.\n");
		try {
			System.in.read();
			System.out.println("Stopped!");
		} catch(Throwable t) {};
	}

}
