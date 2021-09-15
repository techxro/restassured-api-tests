package com.coinmaker.request;

import com.coinmaker.common.Spec;
import io.restassured.response.Response;

import static com.coinmaker.api.Endpoints.*;
import static io.restassured.RestAssured.given;

public class GetCurrency {
    private static Response response;

    public static Response listAllCurrency() {
        response = given()
                .spec(Spec.getCommonSpec())
                .get(MAP);
        response.then().assertThat().statusCode(200);
        return response;
    }

    public static Response convertCurrency(int id, int amount, String symbol) {
        Response response = given()
                .spec(Spec.getCommonSpec())
                .queryParam("id", id)
                .queryParam("convert", symbol)
                .queryParam("amount", amount)
                .get(CONVERT);
        response.then().assertThat().statusCode(200);
        return response;
    }


    public static Response getFirstTenCurrencies() {
        Response response = given()
                .spec(Spec.getCommonSpec())
                .queryParams("id", "1,2,3,4,5,6,7,8,9,10")
                .get(INFO);
        response.then().assertThat().statusCode(200);
        response.then().log().all();
        return response;
    }
}