package testClassPackage;
//import static io.restassured.RestAssured.given;

import java.io.IOException;

//import static io.restassured.RestAssured.given;
import org.testng.Assert;

import commonFunctionPackage.API_Common_function;
import commonFunctionPackage.Utility_Coomon_Fuction;
//import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import requestRepositoryPackage.post_req_repository;

public class post_tc_1{
	
 public static void execute() throws IOException 
 {
		for(int i=0; i<5; i++)
	{   
			String baseURI=post_req_repository.base_URI();
			String requestBody=post_req_repository.post_req_tc1();
	        String resource=post_req_repository.resource();
		int statusCode=API_Common_function.response_statusCode(baseURI, requestBody, resource);
		if(statusCode==201)
	{
		String responseBody=API_Common_function.response_Body(baseURI, requestBody, resource);
		post_tc_1.validator(statusCode,requestBody,responseBody);
		var tmp=post_req_repository.post_req_tc1();
		Utility_Coomon_Fuction.evidencefilecreater("post_tc_1",tmp,responseBody);
		break;
	 } 
		else 
		{
		System.out.println("correct status code is not find hence retrying the API");
		   }
	}
}
  public static void validator(int statusCode,String requestBody,String responseBody)
  {
	  JsonPath jspreq=new JsonPath(requestBody);
		String req_name=jspreq.getString("name");
		String req_job=jspreq.getString("job");
		//int req_id=jspreq.getInt("id");
		
		JsonPath jsp=new JsonPath(responseBody);
		String res_name=jsp.getString("name");
		String res_job=jsp.getString("job");
		//String res_id=jsp.getString("id");
		

	//validate response body 
    Assert.assertEquals(statusCode,201);
	Assert.assertEquals(res_name,req_name);
	Assert.assertEquals(res_job,req_job);
	//Assert.assertEquals(res_id,req_id);
	//Assert.assertNotNull(res_createdAt,req_createdAt);

	}
}
