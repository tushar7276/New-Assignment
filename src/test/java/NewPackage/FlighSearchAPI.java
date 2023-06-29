package NewPackage;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class FlighSearchAPI {
    public  String name;
    @Test
    public void highlightCreation() {
        name=new Object(){
        }.getClass().getEnclosingMethod().getName();
        System.out.println(name);
        RestAssured.baseURI="http://api.aviationstack.com/v1/flights";
        String response=given().log().all().header("Content-Type","application/json")
                        .queryParam("access_key","768f8d50f891f5fd0470880911a0722f")
                .queryParam("flight_number","EY-601")
                .queryParam("dep_iata","JNB")
                .queryParam("arr_iata","AUH")
                .queryParam("flight_date","2023-07-01")
                .when().get("http://api.aviationstack.com/v1/flights")
                .then().log().all().assertThat().statusCode(201).extract().response().asString();
        System.out.println("The response is: " +response);
    }
}
