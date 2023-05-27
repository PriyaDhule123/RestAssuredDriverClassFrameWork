package requestRepositoryPackage;
import java.util.ArrayList;
import java.io.IOException;

import commonFunctionPackage.Utility_Coomon_Fuction;


public class post_req_repository {

	 public static String base_URI() {
		 String baseURI="https://reqres.in/";
		 return baseURI;
	 }
	 
	 
	 public static String post_req_tc1() throws IOException {
			
	 ArrayList<String> data=Utility_Coomon_Fuction.readDataExcel("Post_Test_Data","post_tc_1");
			
	  String req_name= data.get(1);                  
	  String req_job=data.get(2);
	  
		String requestBody="{\r\n"
	            + "    \"name\": \""+req_name+"\",\r\n"
	            + "    \"job\": \""+req_job+"\"\r\n"
	            + "}";
		
		return requestBody;
		
	}
	 public static String resource()
	 {
		 String resource="api/users";
		 return resource;
	 }
}
