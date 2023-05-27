package commonFunctionPackage;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
//import requestRepositoryPackage.post_req_repository;

 public class API_Common_function {

	public static int response_statusCode(String baseURI,String requestBody,String resource) {
		
		RestAssured.baseURI=baseURI;
		
		int statusCode=given().header("Content-Type","application/json").body(requestBody).when().post(resource).then().extract().statusCode();
		
		return statusCode;
	}
	
    public static String response_Body(String baseURI,String requestBody,String resource) {
		
	    RestAssured.baseURI=baseURI;
	    
		String responseBody=given().header("Content-Type","application/json").body(requestBody).when().post(resource).then().extract().response().asString();
		
		//System.out.println(responseBody);
		
		return responseBody;
	}
}
