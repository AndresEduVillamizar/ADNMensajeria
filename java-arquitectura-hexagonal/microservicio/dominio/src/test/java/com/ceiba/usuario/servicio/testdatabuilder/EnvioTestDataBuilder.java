package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.UsuarioEnvio;

public class EnvioTestDataBuilder {

    private Long id;
    private String nombre;
    private String clave;
    private boolean premium;

    public EnvioTestDataBuilder(){
        nombre="NombreEnvio";
        clave="password";
        premium = true;
    }

    public EnvioTestDataBuilder conNombre(String nombre){
        this.nombre=nombre;
        return this;
    }

    public EnvioTestDataBuilder conClave(String clave){
        this.clave=clave;
        return this;
    }

    public EnvioTestDataBuilder esPremium(boolean premium){
        this.premium=premium;
        return this;
    }

    public EnvioTestDataBuilder conId(Long id){
        this.id=id;
        return this;
    }

    public UsuarioEnvio build(){
        return new UsuarioEnvio(id,nombre,clave,premium);
    }
}
