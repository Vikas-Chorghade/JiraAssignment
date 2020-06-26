package com.jira.usrpwdcreateissue;

public class Payload {
	public static final  String account_crt="/rest/auth/1/session";
	
	public static String requestBody() {
		return "{\r\n" + 
				"	    \"username\":\"vikaschorghade\",\r\n" + 
				"	    \"password\": \"Vikas@1216\"\r\n" + 
				"	    \r\n" + 
				"	}";

	}
	
	public static final  String account_crt_issue="/rest/api/2/issue";
	public static String createIssue() {
		
	return "{\r\n" + 
			"    \"fields\": {\r\n" + 
			"       \"project\":\r\n" + 
			"       {\r\n" + 
			"          \"key\": \"WEB\"\r\n" + 
			"       },\r\n" + 
			"       \"summary\": \"Creating new ticket for the Wardrobe RestAPI\",\r\n" + 
			"       \"description\": \"Giving demo for creating a story\",\r\n" + 
			"       \"issuetype\": {\r\n" + 
			"          \"name\": \"Story\"\r\n" + 
			"       }\r\n" + 
			"   }\r\n" + 
			"}";

	}

}

