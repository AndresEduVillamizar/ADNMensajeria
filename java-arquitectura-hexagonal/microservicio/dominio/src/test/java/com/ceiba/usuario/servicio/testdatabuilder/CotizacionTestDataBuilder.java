package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Cotizacion;

public class CotizacionTestDataBuilder {

    private Long id;
    private float distanciaRecorrido;

    public CotizacionTestDataBuilder(){
        id=1L;
        distanciaRecorrido=20;
    }

    public CotizacionTestDataBuilder conDistanciaRecorrido(float distanciaRecorrido){
        this.distanciaRecorrido=distanciaRecorrido;
        return this;
    }

    public CotizacionTestDataBuilder conIdUsuario(Long idUsuario){
        this.id=idUsuario;
        return this;
    }

    public Cotizacion build(){
        return new Cotizacion(
                id,distanciaRecorrido
        );
    }
}
