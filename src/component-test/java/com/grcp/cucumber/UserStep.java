package com.grcp.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserStep extends SpringComponentTest {

    @When("^the client calls /api/v1/users/(\\d+)$")
    public void the_client_issues_GET_version(int userId) throws Throwable {

    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {

    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {

    }
}
