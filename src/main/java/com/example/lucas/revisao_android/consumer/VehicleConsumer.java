package com.example.lucas.revisao_android.consumer;

import com.example.lucas.revisao_android.pojo.Veiculo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by lucas on 26/11/17.
 */

public interface VehicleConsumer {
    String URL_BASE = "http://192.168.0.104:8080/compubras/";

    @GET("veiculo/")
    Call<List<Veiculo>> get();

    @GET("veiculo/{id}")
    Call<Veiculo> get(@Path("id") int id);

    @POST("veiculo/")
    Call<Veiculo> post(@Body Veiculo v);

    @PUT("veiculo/")
    Call<Veiculo> put(@Body Veiculo v);

    @GET("veiculo/{id}")
    Call<Veiculo> delete(@Path("id") int id);
}
