package com.coinmaker.common;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static com.coinmaker.api.Constants.API_KEY;
import static com.coinmaker.api.Constants.API_KEY_VALUE;
import static com.coinmaker.api.Endpoints.BASEURI;

public class Spec {

    @Before
    public static RequestSpecification getCommonSpec() {
        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setBaseUri(BASEURI)
                .setContentType(ContentType.JSON)
                .setUrlEncodingEnabled(false)
                .addHeader(API_KEY, API_KEY_VALUE);
        RequestSpecification reqSpec = reqBuilder.build().log().all();
        return reqSpec;
    }
}
