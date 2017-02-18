package com.example.rosemberg.sinemaps.service;
    import java.util.List;
    //falta o import da classe dos sines e dos metodos.
    import retrofit2.Call;
    import retrofit2.http.GET;
    import retrofit2.http.Path;
public class ResponseOfService {

    @GET(" ")
    Call<List<Sine>> getSineBrasil();

    @GET("lat/long")
    Call<List<Sine>> getSinecoord();

    @GET("Cod")
    Call<List<Sine>> getSinePorCod(String cod);
}
