import com.aventstack.extentreports.ExtentReports;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static helpers.DataReader.dataReader;
import static io.restassured.RestAssured.given;

public class RestAssuredTest {

    public String baseURL = "https://www.almosafer.com";

    @Test
    public void getFaresCalender() {
        RestAssured.baseURI = baseURL;

        given().
                header("token", dataReader("token")).
                header("content-type", dataReader("contentType")).
                body(ApiReader.readFaresCalenderApiBody()).
                when().
                post(dataReader("faresCalendarApi")).
                then().
                assertThat().statusCode(200);
    }

    @Test
    public void currencyList() {
        RestAssured.baseURI = baseURL;

        Response response = given().
                header("token", dataReader("token")).
                header("content-type", dataReader("contentType")).
                when().
                get(dataReader("countrylistApi")).
                then().
                assertThat().statusCode(200).extract().response();

        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(ApiReader.readCountryListApiSchema()));
    }


}
