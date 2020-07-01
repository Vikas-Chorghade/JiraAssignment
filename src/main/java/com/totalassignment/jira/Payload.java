package com.totalassignment.jira;

public class Payload {
	
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
			"          \"key\": \"VIK\"\r\n" + 
			"       },\r\n" + 
			"       \"summary\": \"Creating new ticket for Covid Hospital\",\r\n" + 
			"       \"description\": \"Giving demo for creating a story\",\r\n" + 
			"       \"issuetype\": {\r\n" + 
			"          \"name\": \"Story\"\r\n" + 
			"       }\r\n" + 
			"   }\r\n" + 
			"}";

	}
	
	public static String comment() {
		
		return "{\r\n" + 
				"  \"body\": \"This is a comment regarding the quality of the response. From Vikas\"\r\n" + 
				"}" ;


		}

}
