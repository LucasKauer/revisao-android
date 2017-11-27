package com.example.lucas.revisao_android.consumer;

import com.example.lucas.revisao_android.pojo.Veiculo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

/**
 * Created by lucas on 26/11/17.
 */

public class VehicleConsumerImpl {
    private VehicleConsumer service;
    private Retrofit retrofit;

    public VehicleConsumerImpl(){
        this.retrofit = new Retrofit.
                Builder().
                baseUrl(VehicleConsumer.URL_BASE).
                addConverterFactory(GsonConverterFactory.create()).
                build();

        this.service = retrofit.create(VehicleConsumer.class);
    }

    public Call<List<Veiculo>> get() {
        return this.service.get();
    }

    public Call<Veiculo> get(@Path("id") int id) {
        return this.service.get(id);
    }

    public Call<Veiculo> post(Veiculo v) {
        return this.service.post(v);
    }

    public Call<Veiculo> put(Veiculo v) {
        return this.service.put(v);
    }

    public Call<Veiculo> delete(@Path("id") int id) {
        return this.service.delete(id);
    }
}
