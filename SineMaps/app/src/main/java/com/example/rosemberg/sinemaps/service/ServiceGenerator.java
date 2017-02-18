package com.example.rosemberg.sinemaps.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    public static final String BASE_URL = "http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/";

    private static ResponseOfService service;
    private static ServiceGenerator instance = new ServiceGenerator();

    public ResponseOfService getService(){
        return service;
    }

    public static ServiceGenerator getInstance(){
        return instance;
    }

    private ServiceGenerator(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ResponseOfService.class);
    }
}
