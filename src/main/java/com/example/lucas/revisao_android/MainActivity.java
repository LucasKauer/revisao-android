package com.example.lucas.revisao_android;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends ListActivity {
    private static List<String> menu =
            Arrays.asList("Cadastrar", "Editar", "Buscar", "Excluir");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeComponents();
    }

    private void initializeComponents() {
        ListAdapter adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent;

        switch (position) {
            case 0:
                intent = new Intent(MainActivity.this, VehicleActivity.class);
                intent.putExtra("action", "register");
                break;
            case 1:
                intent = new Intent(MainActivity.this, ListVehicleActivity.class);
                intent.putExtra("action", "edit");
                break;
            case 2:
                intent = new Intent(MainActivity.this, ListVehicleActivity.class);
                intent.putExtra("action", "search");
                break;
            case 3:
                intent = new Intent(MainActivity.this, ListVehicleActivity.class);
                intent.putExtra("action", "delete");
                break;
            default:
                throw new InvalidParameterException("position");
        }

        startActivity(intent);
        finish();
    }
}
