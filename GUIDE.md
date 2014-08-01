Mule Brightcove Module - User Guide
====================================================
Welcome to Brightcove
---------------------
This module wraps the Brightcove Media API in order to interact with the Video Cloud library. The Media Read APIs are RESTful, all requests are HTTP GET. The Media Write APIs are JSON-RPC, all requests are HTTP POST.

Configuration Reference
-----------------------
In order to connect to Brightcove VIDEOCLOUD services we must specify a connector with the appropriate parameters.

### Config Attributes
<table class="confluenceTable">
	<tr>
		<th>Name</th>
		<th>Type</th>
		<th>Required</th>
		<th>Default</th>
		<th>Description</th>
	</tr>
	<tr>
		<td>readToken</td>
		<td>string</td>
		<td>yes</td>
		<td></td>
		<td>Read Token a Brightcove account must have in order excecute read operations</td>
	</tr>
	<tr>
		<td>writeToken</td>
		<td>string</td>
		<td>yes</td>
		<td></td>
		<td>Write Token a Brightcove account must have in order excecute write operations (insert/delete/update)</td>
	</tr>	
	<tr>
		<td>restUrl</td>
		<td>string</td>
		<td>yes</td>
		<td></td>
		<td>Rest API base URL</td>
	</tr>	
</table>

For example:

	    <brightcove:config name="BrightcoveConfig" restUrl="http://localhost:8090" readToken="readTokenString" writeToken="writeTokenString" />

Read Operations Reference
-----------------------	    
	    
### Find Playlist By Reference Id
Retrieve a playlist based on its publisher-assigned reference Id.

<table class="confluenceTable">
	<tr>
		<th>Name</th>
		<th>Type</th>
		<th>Required</th>
		<th>Default</th>
		<th>Description</th>
	</tr>
	<tr>
		<td>config-ref</td>
		<td>String</td>
		<td>true</td> 
		<td></td>
		<td>Reference to the config element</td>
	</tr>
	<tr>
		<td>referenceId</td>
		<td>String</td>
		<td>true</td>
		<td></td>
		<td>Id of the playlist we want to retrieve</td>
	</tr>
</table>

For example:
	
	    	<brightcove:find-playlist-by-reference-id config-ref="BrightcoveConfig" referenceId="pl_test" />
	    	
### Find Video By Id
Retrieve a video bases on its video Id.

<table class="confluenceTable">
	<tr>
		<th>Name</th>
		<th>Type</th>
		<th>Required</th>
		<th>Default</th>
		<th>Description</th>
	</tr>
	<tr>
		<td>config-ref</td>
		<td>String</td>
		<td>true</td>
		<td></td>
		<td>Reference to the config element</td>
	</tr>
	<tr>
		<td>videoId</td>
		<td>String</td>
		<td>true</td>
		<td></td>
		<td>Id of the video we want to retrieve</td>
	</tr>
</table>

For example:

			<brightcove:find-video-by-id  config-ref="Brightcove" videoId="#[map-payload:id]" doc:name="Brightcove"/>
		
Write Operations Reference
-----------------------	    			
### Delete Playlist
Delete the playlist based on its playlist Id.

<table class="confluenceTable">
	<tr>
		<th>Name</th>
		<th>Type</th>
		<th>Required</th>
		<th>Default</th>
		<th>Description</th>
	</tr>
	<tr>
		<td>config-ref</td>
		<td>String</td>
		<td>true</td>
		<td></td>
		<td>Reference to the config element</td>
	</tr>
	<tr>
		<td>playlistId</td>
		<td>String</td>
		<td>true</td>
		<td></td>
		<td>Id of the playlist we want to delete</td>
	</tr>
</table>

For example:

	<brightcove:delete-playlist config-ref="Brightcove" playlistId="#[map-payload:d]" doc:name="Brightcove"/>			
			
### Delete Video
Delete the video based on its video Id.

<table class="confluenceTable">
	<tr>
		<th>Name</th>
		<th>Type</th>
		<th>Required</th>
		<th>Default</th>
		<th>Description</th>
	</tr>
	<tr>
		<td>config-ref</td>
		<td>String</td>
		<td>true</td>
		<td></td>
		<td>Reference to the config element</td>
	</tr>
	<tr>
		<td>videoId</td>
		<td>String</td>
		<td>true</td>
		<td></td>
		<td>Id of the video we want to delete</td>
	</tr>
</table>

For example:

		    	<brightcove:delete-video config-ref="Brightcove"  doc:name="Brightcove" videoId="#[map-payload:id]"/>

