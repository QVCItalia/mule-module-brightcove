/**
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 **/
        
/**
 * This file was automatically generated by the Mule Development Kit
 */
package it.qvc;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.mule.api.ConnectionException;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.param.ConnectionKey;


/**
 * Cloud Connector
 *
 * @author MuleSoft, Inc.
 */
@Connector(name="brightcove", schemaVersion="1.0-SNAPSHOT")
public class BrightcoveConnector
{
	private static final Log logger = LogFactory.getLog(BrightcoveConnector.class);
	
	private enum Operation {
		delete_video, delete_playlist
	}
	
	private static final String FIND_PLAYLIST_BY_REFERENCE_ID = "?command=$command&token=$read_token&reference_id=$reference_id";
	private static final String PLAYLIST_PARAMS = "&playlist_fields=id,videos&video_fields=id,itemState";
	
	private static final String FIND_VIDEO_BY_ID = "?command=find_video_by_id&token=$read_token&video_id=$video_id&media_delivery=http&video_fields=id%2Cname%2Crenditions";
	
	private static final String GET_URL = "/services/library";
	private static final String POST_URL = "/services/post";
	
	
	private static final String METHOD_KEY = "method";
	private static final String METHOD_DELETE_VIDEO = "delete_video";
	private static final String METHOD_DELETE_PLAYLIST = "delete_playlist";
	
	private static final String TOKEN_KEY = "token";
	private static final String VIDEO_ID_KEY = "video_id";
	private static final String PLAYLIST_ID_KEY = "playlist_id";
	
	private static final String PARAMS_KEY = "params"; 
	
	private static final String JSON_STRING = "JSON-RPC";
	
    /**
     * Read Token for read operations
     */
    @Configurable
    private String readToken;

    /**
     * Write Token for write operations
     */
    @Configurable
    private String writeToken;

    /**
     * REST GET base URL
     * */
    @Configurable
    private String restUrl;
   
    
    /**
     * Set property
     *
     * @param readToken My property
     */
    public void setReadToken(String readToken)
    {
        this.readToken = readToken;
    }
 
    public String getReadToken(){
        return this.readToken;
    }

    /**
     * Set property
     *
     * @param writeToken Write Token in order to write
     */
    public void setWriteToken(String writeToken)
    {
        this.writeToken = writeToken;
    }

    public String getWriteToken(){
        return this.writeToken;
    }
    
    /**
     * Set property
     *
     * @param restUrl REST API base URL
     */
    public void setRestUrl(String restUrl)
    {
        this.restUrl = restUrl;
    }

    public String getRestUrl() {
    	return this.restUrl;
    }
    
    


	
    
    
    
    /**
     * Connect
     *
     * @param username A username
     * @param password A password
     * @throws ConnectionException
     */
    @Connect
    public void connect(@ConnectionKey String username, @Password String password)
        throws ConnectionException {
        /*
         * CODE FOR ESTABLISHING A CONNECTION GOES HERE
         */
    }

    /**
     * Disconnect
     */
    @Disconnect
    public void disconnect() {
        /*
         * CODE FOR CLOSING A CONNECTION GOES HERE
         */
    }

    /**
     * Are we connected
     */
    @ValidateConnection
    public boolean isConnected() {
        return true;
    }

    /**
     * Connection identifier
     */
    @ConnectionIdentifier
    public String connectionId() {
        return "001";
    }

    
    /**
    * Find Playlist By referenceId 
    *
    * {@sample.xml ../../../doc/Brightcove-connector.xml.sample brightcove:find-playlist-by-reference-id}
    *
    * @param referenceId SKN of the videos to be deleted
    * @return Some string
    */
   @Processor
    public  String findPlaylistByReferenceId(String referenceId) {
	   
		String urlString = getRestUrl() + GET_URL + FIND_PLAYLIST_BY_REFERENCE_ID;
		
		urlString = urlString.replace("$command", "find_playlist_by_reference_id");
		urlString = urlString.replace("$reference_id", referenceId);
		urlString = urlString.replace("$read_token", getReadToken());
		urlString += PLAYLIST_PARAMS;
		
	   	HttpURLConnection conn = null;
		InputStream in = null;
		URL url;
		String result = "";
		
		try {
			/* Set Http Connection */
			url = new URL(urlString);						
			conn = (HttpURLConnection) url.openConnection();
	    	conn.setRequestMethod("GET");
	    	
	    	conn.connect();
	    	
	    	in = conn.getInputStream();
	    	result = IOUtils.toString(in, "UTF-8");
				    	
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			if (conn != null) {
				conn.disconnect();	
			}
			
		}	
		
	   return result;
    }
   
   /**
    * Find Video Information By videoId 
    *
    * {@sample.xml ../../../doc/Brightcove-connector.xml.sample brightcove:find-video-by-id}
    *
    * @param videoId Video Id of the video we want to retrieve information
    * @return Some string
    */
   @Processor
    public  String findVideoById(String videoId) {
	   
		String urlString = getRestUrl() + GET_URL + FIND_VIDEO_BY_ID;
		
		urlString = urlString.replace("$command", "find_video_by_id");
		urlString = urlString.replace("$video_id", videoId);
		urlString = urlString.replace("$read_token", getReadToken());
		
	   	HttpURLConnection conn = null;
		InputStream in = null;
		URL url;
		String result = "";
		
		try {
			/* Set Http Connection */
			url = new URL(urlString);						
			conn = (HttpURLConnection) url.openConnection();
	    	conn.setRequestMethod("GET");
	    	
	    	conn.connect();
	    	
	    	in = conn.getInputStream();
	    	result = IOUtils.toString(in, "UTF-8");
				    	
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			if (conn != null) {
				conn.disconnect();	
			}
			
		}	
		
	   return result;
    }
   
   
   /**
   * Custom processor
   *
   * {@sample.xml ../../../doc/Brightcove-connector.xml.sample brightcove:delete-video}
   *
   * @param videoId Video Id of the video has to be deleted
   * @return Some string
   */
   @Processor
   public String deleteVideo(String videoId) {
	   
	   String result = "";
	   		   
	   String jsonString = createJson(METHOD_DELETE_VIDEO, videoId, null);
	   
 	   result = postRequest(jsonString);
		   		
 	   return result;
   }
   

   /**
    * Delete Playlist processor
    *
    * {@sample.xml ../../../doc/Brightcove-connector.xml.sample brightcove:delete-playlist}
    *
    * @param playlistId Playlist Id of the playlist has to be deleted
    * @return Some string
    */
    @Processor
    public String deletePlaylist(String playlistId) {
 	   
 	   String result = "";
 	    		   
 	   String jsonString = createJson(METHOD_DELETE_PLAYLIST, playlistId, null);
 	   
 	   result = postRequest(jsonString);
 		    		
 	   return result;
    }   
   
 
    /**
     * It builds the appropriate Json string based on the operation and parameters
     * */
    private String createJson(String operation, String id, Map<String, String> params) {
    	String json = "";
    	String method = null;
    	String idName = null;
		JSONObject jsonObj = new JSONObject();
		JSONObject paramsJsonObj = new JSONObject();
    	Operation op = Operation.valueOf(operation);
		
		switch(op) {
			case delete_video:
				method = METHOD_DELETE_VIDEO;
				idName = VIDEO_ID_KEY;
			break;
			
			case delete_playlist:
				method = METHOD_DELETE_PLAYLIST;
				idName = PLAYLIST_ID_KEY;
			break;
		
		}
    	

		jsonObj.put(METHOD_KEY, method);
		
		paramsJsonObj.put(TOKEN_KEY, getWriteToken());
		paramsJsonObj.put(idName, id);
		
		jsonObj.put(PARAMS_KEY, paramsJsonObj);
	
		json = jsonObj.toJSONString();
		logger.info(json);
		
    	return json;
    }
 
    
    /**
     * It POSTs the request and handles the response
     * */
    private String postRequest(String jsonString) {
    	String response = "";
    	Object[] objParams = new Object[] {JSON_STRING, jsonString};

    	try {
    		InputStream in = ClientHttpRequest.post(new URL(getRestUrl() + POST_URL), objParams);
    		response = IOUtils.toString(in);		
    	} catch (MalformedURLException e) {
    		logger.error(e, e);
    	} catch (IOException e) {
    		logger.error(e, e);
    	}    	
    	
    	return response;
    }
    
}
