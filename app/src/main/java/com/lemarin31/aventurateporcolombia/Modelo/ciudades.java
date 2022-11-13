package com.lemarin31.aventurateporcolombia.Modelo;

public class ciudades {
    String Festividades,Gastronomia,Historia;
    public ciudades(){}
    public ciudades (String Festividades,String Gastronomia,String Historia){

        this.Festividades = Festividades;
        this.Gastronomia = Gastronomia;
        this.Historia = Historia;
    }

    public String getFestividades() {
        return Festividades;
    }

    public void setFestividades(String festividades) {
        Festividades = festividades;
    }

    public String getGastronomia() {
        return Gastronomia;
    }

    public void setGastronomia(String gastronomia) {
        Gastronomia = gastronomia;
    }

    public String getHistoria() {
        return Historia;
    }

    public void setHistoria(String historia) {
        Historia = historia;
    }
}
