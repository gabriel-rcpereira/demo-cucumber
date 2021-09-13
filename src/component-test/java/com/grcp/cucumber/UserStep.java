package com.grcp.cucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class UserStep extends ApplicationTestContext {

    private String api;
    private Response response;
    private ValidatableResponse validatableResponse;

    @Before
    public void setup() {
        RestAssured.port = port;
    }

    @Given("the api {string}")
    public void the_url(String api) {
        this.api = api;
    }

    @When("the client sends a get request")
    public void the_client_sends_get_request() {
        this.response = given().contentType(ContentType.JSON)
                .when().get(this.api);
    }

    @Then("the client receives status code of {int}")
    public void the_client_receives_status_code_of(int statusCode) {
        this.validatableResponse = this.response.then().statusCode(statusCode);
    }

    @And("the client receives a response body equals to {string}")
    public void the_response_body_equals_to(String bodyFile) throws IOException, URISyntaxException {
        var url = getClass().getClassLoader().getResource(String.format("%s.json", bodyFile));
        var bytes = Files.readAllBytes(Paths.get(url.toURI()));
        this.validatableResponse.body(MyMatcher.equalToIgnoringWhiteSpaces(new String(bytes)));
    }

    static class MyMatcher extends TypeSafeMatcher<String> {

        private final String toBeStriped;

        public MyMatcher(String string) {
            this.toBeStriped = string;
        }

        @Override
        protected boolean matchesSafely(String s) {
            return this.strip(this.toBeStriped).equals(this.strip(s));
        }

        @Override
        public void describeTo(Description description) {

        }

        public static MyMatcher equalToIgnoringWhiteSpaces(String s) {
            return new MyMatcher(s);
        }

        private String strip(String s) {
            return s.replaceAll("\\r+|\\n+", "").replaceAll("\\s+", "");
        }
    }
}
