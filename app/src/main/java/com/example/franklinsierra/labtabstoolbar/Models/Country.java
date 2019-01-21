package com.example.franklinsierra.labtabstoolbar.Models;

import java.text.MessageFormat;

public class Country {

    //atributos
    private String name;
    private String codeCountry;

    public Country(String name, String codeCountry) {
        this.name = name;
        this.codeCountry = codeCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(String codeCountry) {
        this.codeCountry = codeCountry;
    }



    //  ++++ METODO QUE CARGA LAS IMAGENES DE CADA PAIS DE ACUERDO A SU CODIGO  ++++    //
    public String getFlagUrl(){
        return MessageFormat.format("http://www.geognos.com/api/en/countries/flag/{0}",this.codeCountry);
    }




    // Importante!! Sobreescribimos el método toString de nuestra clase POJO Country
    // Para que cuando el Spinner llame internamente cada objeto, use el name para ser mostrado
    // como único valor posible en la lista desplegable
    @Override
    public String toString() {
        return name;
    }
}
