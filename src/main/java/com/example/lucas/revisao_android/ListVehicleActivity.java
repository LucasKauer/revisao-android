package com.example.lucas.revisao_android;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.lucas.revisao_android.consumer.VehicleConsumerImpl;
import com.example.lucas.revisao_android.pojo.Veiculo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListVehicleActivity extends ListActivity {

    private VehicleConsumerImpl vehicleConsumer = new VehicleConsumerImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vehicleConsumer.get().enqueue(new Callback<List<Veiculo>>() {
            @Override
            public void onResponse(Call<List<Veiculo>> call, Response<List<Veiculo>> response) {
                List<Veiculo> vehicles = response.body();
                ArrayAdapter<Veiculo> adapter = new ArrayAdapter<Veiculo>(ListVehicleActivity.this, android.R.layout.simple_list_item_1, vehicles);
                setListAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Veiculo>> call, Throwable t) {
                Toast.makeText(ListVehicleActivity.this, "Xabu", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
