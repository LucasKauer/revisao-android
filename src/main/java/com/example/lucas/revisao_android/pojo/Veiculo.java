package com.example.lucas.revisao_android.pojo;

import java.io.Serializable;

/**
 * Created by lucas on 26/11/17.
 */

public class Veiculo implements Serializable {
    private String placa;
    private String cor;
    private String marca;
    private boolean novo;

    public Veiculo() { }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isNovo() {
        return novo;
    }

    public void setNovo(boolean novo) {
        this.novo = novo;
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s:%s",
                this.placa,
                this.cor,
                this.marca,
                this.novo ? "Novo" : "Semi");
    }
}
