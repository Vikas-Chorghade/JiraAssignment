package com.totalassignment.jira;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class AddcommentToTicket {
	
	static SessionFilter session = new SessionFilter();
	static String createsession="/rest/auth/1/session";
	static String createissue="/rest/api/2/issue";
	static String addattachment="/rest/api/2/issue/{key}/attachments";
	static String addcomment="/rest/api/2/issue/{key}/comment";
	static String ticketno=null;
	static String jsonissue;
	
	
	public static void main(String[] args) throws IOException {
		RestAssured.baseURI = "http://localhost:8081";
		createSession();
		createIssue();
		createAttachment();
		commentOnTicket();
	}
		
	public  static void createSession()  {
					String responsebody = given().log().all()
		    		 .header("content-type", "application/json")
		    		 .body(Payload.requestBody())
		    		 .filter(session)
		    		 .when()
		    		 .post(createsession)
		    		 .then().log().all()
		    		 .assertThat().statusCode(200)
		    		 //.body("session.value", Matchers.notNullValue())
		    		 .body("session.value",notNullValue())
		    		 .extract().asString();
					 
					
		    	     System.out.println(responsebody);
				}
			

				public  static void  createIssue () throws IOException 
				{ 
					String filereader = generateStringFromFile("D:\\RestAPI\\RestAPIs\\src\\main\\resources\\Createissuedata.json");
					 jsonissue=given().log().all()
					.header("content-type", "application/json")
					.body(filereader)
					.filter(session)
				    .when()
				    .post(createissue)
				    .then().log().all()
				    .assertThat().statusCode(201)
				    .body("key",notNullValue())
				    .extract().asString();
					
					JsonPath js=new JsonPath(jsonissue);
					 ticketno=js.getString("key");
					 System.out.println("Key is:"+ticketno);
					 	
					 
				}
				
				public static void createAttachment() {
					given().log().all().header("X-Atlassian-Token", "nocheck")
					.header("content-type","multipart/form-data")
			 		.filter(session)
					.pathParam("key", ticketno)
					.multiPart("file",new File("C:\\Users\\dell\\Desktop\\path.txt"))
					.when()
					.post(addattachment)
					.then().log().all()
					.assertThat().statusCode(200);
				

				}
		
			public  static void commentOnTicket()
				{
				String responsebody=given().log().all().header("content-type", "application/json")
				.body(Payload.comment())
				.filter(session)
				.pathParam("key", ticketno)
				.when()
				.post(addcomment)
				.then().log().all()
				.assertThat().statusCode(201)
				.body("body", equalTo("This is a comment regarding the quality of the response. From Vikas"))
				.extract().asString();
				System.out.println(responsebody);
				}
				
				private static String generateStringFromFile(String path) throws IOException {

					return new String(Files.readAllBytes(Paths.get(path)));
				}

	
	


}
