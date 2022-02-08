package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoCotizacion;

public class ComandoCotizacionTestDataBuilder {

    private Long id;
    private float distanciaRecorrido;

    public ComandoCotizacionTestDataBuilder(){
        id=1L;
        distanciaRecorrido=20;
    }

    public ComandoCotizacionTestDataBuilder conIdUsuario(Long idUsuario){
        this.id = idUsuario;
        return this;
    }

    public ComandoCotizacionTestDataBuilder conDistanciaRecorrido(float distanciaRecorrido){
        this.distanciaRecorrido=distanciaRecorrido;
        return this;
    }

    public ComandoCotizacion build(){
        return new ComandoCotizacion(id,distanciaRecorrido);
    }
}
