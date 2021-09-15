package com.coinmaker.request;

import com.coinmaker.common.Spec;
import io.restassured.response.Response;

import static com.coinmaker.api.Endpoints.INFO;
import static io.restassured.RestAssured.given;


public class GetCurrencyInfo {
    public static Response getIDofCurrency() {
        Response response = given()
                .spec(Spec.getCommonSpec())
                .queryParam("id", 1027) //Ethereum id = 1027
                .get(INFO );
        response.then().assertThat().statusCode(200);
        return response;
    }
}
