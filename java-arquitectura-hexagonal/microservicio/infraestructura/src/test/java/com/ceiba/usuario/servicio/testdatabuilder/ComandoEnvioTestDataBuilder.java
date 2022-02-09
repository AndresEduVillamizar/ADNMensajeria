package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoEnvio;

public class ComandoEnvioTestDataBuilder {

    private Long id;
    private String nombre;
    private String clave;
    private boolean premium;

    public ComandoEnvioTestDataBuilder(){
        nombre="test";
        clave="1234";
        premium = true;
    }

    public ComandoEnvioTestDataBuilder conNombre(String nombre){
        this.nombre=nombre;
        return this;
    }

    public ComandoEnvioTestDataBuilder conClave(){
        this.clave=clave;
        return this;
    }

    public ComandoEnvio build(){
        return new ComandoEnvio(
                id,nombre,clave,premium
        );
    }
}
