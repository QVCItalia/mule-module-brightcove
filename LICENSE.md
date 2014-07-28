Mule Brightcove Module - User Guide
====================================================
Welcome to Brightcove
---------------------
Configuration Reference
-----------------------
In order to connect to Brightcove VIDEOCLOUD services we must specify a connector with the specific parameters.

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
		<td>Reference Id of the playlist we want to retrieve</td>
	</tr>
</table>

For example:
	
	    	<brightcove:find-playlist-by-reference-id config-ref="BrightcoveConfig" referenceId="pl_test" />
	    	
