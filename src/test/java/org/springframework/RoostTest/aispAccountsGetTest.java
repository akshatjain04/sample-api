// ********RoostGPT********
/*
Test generated by RoostGPT for test MiniProjects using AI Type Open AI and AI Model gpt-4-1106-preview

Test generated for /aisp/accounts_get for http method type GET in rest-assured framework

RoostTestHash=54345701f2


*/

// ********RoostGPT********
package org.springframework.RoostTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.JSONObject;
import org.json.XML;
import org.json.JSONException;
import org.json.JSONArray;
import java.util.Arrays;

public class aispAccountsGetTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @Before
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      String[] envVarsList = {""};
      envList = dataloader.load("src\\test\\java\\org\\springframework\\RoostTest\\aisp_accountsGetTest.csv", envVarsList);
    }

  
    @Test  
    public void aispAccountsGet_Test() throws JSONException {
        this.setUp();
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = (testData.get("BASE_URL") != null && !testData.get("BASE_URL").isEmpty()) ? testData.get("BASE_URL"): "https://sandbox.ob.business.hsbc.com.hk/mock/open-banking/v1.0";  
  
                Response responseObj = given()
				.header("Authorization", testData.get("Authorization") != null ? testData.get("Authorization") : "")
				.header("x-fapi-auth-date", testData.get("x-fapi-auth-date") != null ? testData.get("x-fapi-auth-date") : "")
				.header("x-fapi-customer-ip-address", testData.get("x-fapi-customer-ip-address") != null ? testData.get("x-fapi-customer-ip-address") : "")
				.header("x-fapi-interaction-id", testData.get("x-fapi-interaction-id") != null ? testData.get("x-fapi-interaction-id") : "")
				.header("Accept-Language", testData.get("Accept-Language") != null ? testData.get("Accept-Language") : "")
                .when()
                .get("/aisp/accounts")  
                .then() 
                .extract().response(); 
              JsonPath response;
              String contentType = responseObj.getContentType();

              if (testData.get("statusCode") != null) {
                MatcherAssert.assertThat(responseObj.statusCode(),
                    equalTo(Integer.parseInt(testData.get("statusCode"))));
              }
             else{
                 List<Integer> expectedStatusCodes = Arrays.asList(200,400,401,403,405,406,429,500,503,504);
              MatcherAssert.assertThat(responseObj.statusCode(), is(in(expectedStatusCodes)));
                 }
              
        switch(responseObj.statusCode()){
        
          case 200:
         
          case 400:
         
          case 401:
         
          case 403:
         
          case 405:
         
          case 406:
         
          case 429:
         
          case 500:
         
          case 503:
         
          case 504:
         
           MatcherAssert.assertThat(contentType, equalTo("application/json"));
           break;
        
    }
      
              if (contentType.contains("application/xml") || contentType.contains("text/xml")) {
                String xmlResponse = responseObj.asString();
                JSONObject jsonResponse = XML.toJSONObject(xmlResponse);
                JSONObject jsonData = jsonResponse.getJSONObject("xml");
                String jsonString = jsonData.toString();
                response = new JsonPath(jsonString);
        
              } else if(contentType.contains("application/json")){  
                response = responseObj.jsonPath(); 
              } else {
                System.out.println("Response content type found: "+contentType+", but RoostGPT currently only supports the following response content types: application/json,text/xml,application/xml");
                continue;
              }
         
                if (responseObj.statusCode() == 200) {
					System.out.println("Description: OK");
      
              if (response.get("data") != null) {      
              if (response.get("data.account") != null) {        
                  for (int i = 0; i < response.getList("data.account").size(); i++) {      
              if (response.get("data.account["+ i +"].accountId") != null) {  
                MatcherAssert.assertThat(response.get("data.account["+ i +"].accountId"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("data.account["+ i +"].accountId").length(), lessThanOrEqualTo(40));
  
          }
      
              if (response.get("data.account["+ i +"].accountNumber") != null) {  
                MatcherAssert.assertThat(response.get("data.account["+ i +"].accountNumber"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("data.account["+ i +"].accountNumber").length(), lessThanOrEqualTo(256));
  
          }
      
              if (response.get("data.account["+ i +"].accountType") != null) {  
                MatcherAssert.assertThat(response.get("data.account["+ i +"].accountType"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("data.account["+ i +"].accountType"), anyOf(equalTo("Business"), equalTo("Personal")));
  
          }
      
              if (response.get("data.account["+ i +"].accountSubType") != null) {  
                MatcherAssert.assertThat(response.get("data.account["+ i +"].accountSubType"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("data.account["+ i +"].accountSubType"), anyOf(equalTo("Savings"), equalTo("Current")));
  
          }
      
              if (response.get("data.account["+ i +"].productName") != null) {  
                MatcherAssert.assertThat(response.get("data.account["+ i +"].productName"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("data.account["+ i +"].productName").length(), lessThanOrEqualTo(60));
  
          }
      
              if (response.get("data.account["+ i +"].accountStatus") != null) {  
                MatcherAssert.assertThat(response.get("data.account["+ i +"].accountStatus"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("data.account["+ i +"].accountStatus"), anyOf(equalTo("Active"), equalTo("Inactive"), equalTo("Unavailable"), equalTo("Retry"), equalTo("Error")));
  
          }
      
              if (response.get("data.account["+ i +"].currency") != null) {    
                MatcherAssert.assertThat(response.getString("data.account["+ i +"].currency"), matchesPattern("^[A-Z]{3,3}$")); 
  
                MatcherAssert.assertThat(response.get("data.account["+ i +"].currency"), instanceOf(String.class));  
          }
        
                    }    
                MatcherAssert.assertThat(response.getList("data.account"), instanceOf(List.class));
  
          }
  
          }
      
              if (response.get("links") != null) {      
              if (response.get("links.self") != null) {  
                MatcherAssert.assertThat(response.get("links.self"), instanceOf(String.class));  
          }
      
              if (response.get("links.prev") != null) {  
                MatcherAssert.assertThat(response.get("links.prev"), instanceOf(String.class));  
          }
      
              if (response.get("links.next") != null) {  
                MatcherAssert.assertThat(response.get("links.next"), instanceOf(String.class));  
          }
  
          }
				}
if (responseObj.statusCode() == 400) {
					System.out.println("Description: Bad Request");
      
              if (response.get("id") != null) {  
                MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("id").length(), lessThanOrEqualTo(40));
  
                MatcherAssert.assertThat(response.getString("id").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors") != null) {        
                  for (int i = 0; i < response.getList("errors").size(); i++) {      
              if (response.get("errors["+ i +"].code") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].code"), instanceOf(String.class));  
          }
      
              if (response.get("errors["+ i +"].causes") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].causes"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors["+ i +"].extendedDetails") != null) {      
              if (response.get("errors["+ i +"].extendedDetails.path") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].extendedDetails.path"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), greaterThanOrEqualTo(1));
  
          }
  
          }
        
                    }    
                MatcherAssert.assertThat(response.getList("errors"), instanceOf(List.class));
  
          }
				}
if (responseObj.statusCode() == 401) {
					System.out.println("Description: Unauthorised");
				}
if (responseObj.statusCode() == 403) {
					System.out.println("Description: Forbidden");
				}
if (responseObj.statusCode() == 405) {
					System.out.println("Description: Method Not Allowed");
      
              if (response.get("id") != null) {  
                MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("id").length(), lessThanOrEqualTo(40));
  
                MatcherAssert.assertThat(response.getString("id").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors") != null) {        
                  for (int i = 0; i < response.getList("errors").size(); i++) {      
              if (response.get("errors["+ i +"].code") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].code"), instanceOf(String.class));  
          }
      
              if (response.get("errors["+ i +"].causes") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].causes"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors["+ i +"].extendedDetails") != null) {      
              if (response.get("errors["+ i +"].extendedDetails.path") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].extendedDetails.path"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), greaterThanOrEqualTo(1));
  
          }
  
          }
        
                    }    
                MatcherAssert.assertThat(response.getList("errors"), instanceOf(List.class));
  
          }
				}
if (responseObj.statusCode() == 406) {
					System.out.println("Description: Not Acceptable");
      
              if (response.get("id") != null) {  
                MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("id").length(), lessThanOrEqualTo(40));
  
                MatcherAssert.assertThat(response.getString("id").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors") != null) {        
                  for (int i = 0; i < response.getList("errors").size(); i++) {      
              if (response.get("errors["+ i +"].code") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].code"), instanceOf(String.class));  
          }
      
              if (response.get("errors["+ i +"].causes") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].causes"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors["+ i +"].extendedDetails") != null) {      
              if (response.get("errors["+ i +"].extendedDetails.path") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].extendedDetails.path"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), greaterThanOrEqualTo(1));
  
          }
  
          }
        
                    }    
                MatcherAssert.assertThat(response.getList("errors"), instanceOf(List.class));
  
          }
				}
if (responseObj.statusCode() == 429) {
					System.out.println("Description: Too Many Requests");
      
              if (response.get("message") != null) {  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));  
          }
				}
if (responseObj.statusCode() == 500) {
					System.out.println("Description: Internal Server Error");
      
              if (response.get("id") != null) {  
                MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("id").length(), lessThanOrEqualTo(40));
  
                MatcherAssert.assertThat(response.getString("id").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors") != null) {        
                  for (int i = 0; i < response.getList("errors").size(); i++) {      
              if (response.get("errors["+ i +"].code") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].code"), instanceOf(String.class));  
          }
      
              if (response.get("errors["+ i +"].causes") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].causes"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].causes").length(), greaterThanOrEqualTo(1));
  
          }
      
              if (response.get("errors["+ i +"].extendedDetails") != null) {      
              if (response.get("errors["+ i +"].extendedDetails.path") != null) {  
                MatcherAssert.assertThat(response.get("errors["+ i +"].extendedDetails.path"), instanceOf(String.class));  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), lessThanOrEqualTo(500));
  
                MatcherAssert.assertThat(response.getString("errors["+ i +"].extendedDetails.path").length(), greaterThanOrEqualTo(1));
  
          }
  
          }
        
                    }    
                MatcherAssert.assertThat(response.getList("errors"), instanceOf(List.class));
  
          }
				}
if (responseObj.statusCode() == 503) {
					System.out.println("Description: Service Unavailable");
      
              if (response.get("message") != null) {  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));  
          }
				}
if (responseObj.statusCode() == 504) {
					System.out.println("Description: Gateway Timeout");
      
              if (response.get("message") != null) {  
                MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));  
          }
				}
  
            }  
    }
}
