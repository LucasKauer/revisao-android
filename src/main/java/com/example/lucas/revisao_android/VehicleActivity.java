package com.example.lucas.revisao_android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lucas.revisao_android.consumer.VehicleConsumerImpl;
import com.example.lucas.revisao_android.pojo.Veiculo;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VehicleActivity extends Activity {

    private static List<String> brands = Arrays.asList("Chevrolet", "Fiat", "Ford", "Volkswagen");

    private VehicleConsumerImpl vehicleConsumer = new VehicleConsumerImpl();

    private EditText etLicensePlate;
    private EditText etColor;
    private Spinner spBrand;
    private RadioGroup rgType;
    private RadioButton rbNew;
    private Button btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_vehicle);
        initializeComponents();
        configureSave();
    }

    private void initializeComponents() {
        this.etLicensePlate = findViewById(R.id.et_license_plate);
        this.etColor = findViewById(R.id.et_color);
        this.spBrand = findViewById(R.id.sp_brand);
        this.rgType = findViewById(R.id.rg_type);
        this.rbNew = findViewById(R.id.rb_new);
        this.btSalvar = findViewById(R.id.bt_save);

        ArrayAdapter adapter =
                new ArrayAdapter<>(VehicleActivity.this, android.R.layout.simple_list_item_1, brands);
        this.spBrand.setAdapter(adapter);
    }

    private void configureSave() {
        String action = getIntent().getStringExtra("action");
        switch (action) {
            case "register":
                this.btSalvar.setOnClickListener(configureRegister());
                break;
            default:
                break;
        }
    }

    private View.OnClickListener configureRegister() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Veiculo vehicle = populateVehicle();

                vehicleConsumer.post(vehicle).enqueue(new Callback<Veiculo>() {
                    @Override
                    public void onResponse(Call<Veiculo> call, Response<Veiculo> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(VehicleActivity.this,"Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<Veiculo> call, Throwable t) {
                        Toast.makeText(VehicleActivity.this,"Xabu", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
    }

    public Veiculo populateVehicle() {
        Veiculo vehicle = new Veiculo();

        vehicle.setPlaca(etLicensePlate.getText().toString());
        vehicle.setCor(etColor.getText().toString());
        vehicle.setMarca(spBrand.getSelectedItem().toString());

        boolean isUsed = rgType.getCheckedRadioButtonId() == this.rbNew.getId();
        vehicle.setNovo(isUsed);

        return vehicle;
    }
}
