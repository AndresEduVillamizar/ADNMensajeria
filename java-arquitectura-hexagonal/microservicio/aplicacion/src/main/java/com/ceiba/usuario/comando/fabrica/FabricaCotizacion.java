package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoCotizacion;
import com.ceiba.usuario.modelo.entidad.Cotizacion;
import org.springframework.stereotype.Component;

@Component
public class FabricaCotizacion {

    public Cotizacion crear(ComandoCotizacion comandoCotizacion){
        return new Cotizacion(
                comandoCotizacion.getIdUsuario(),
                comandoCotizacion.getDistanciaRecorrido()
        );
    }
}
