package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoCotizacion;
import com.ceiba.usuario.comando.fabrica.FabricaCotizacion;
import com.ceiba.usuario.modelo.entidad.Cotizacion;
import com.ceiba.usuario.servicio.ServicioGenerarCotizacion;
import org.springframework.stereotype.Component;

@Component
public class ManejadorGeneradorCotizacion implements ManejadorComandoRespuesta<ComandoCotizacion, ComandoRespuesta<Double>> {

    private final FabricaCotizacion fabricaCotizacion;
    private final ServicioGenerarCotizacion servicioGenerarCotizacion;

    public ManejadorGeneradorCotizacion(FabricaCotizacion fabricaCotizacion, ServicioGenerarCotizacion servicioGenerarCotizacion) {
        this.fabricaCotizacion = fabricaCotizacion;
        this.servicioGenerarCotizacion = servicioGenerarCotizacion;
    }

    public ComandoRespuesta<Double> ejecutar(ComandoCotizacion comandoCotizacion) {
        Cotizacion cotizacion = this.fabricaCotizacion.crear(comandoCotizacion);
        return new ComandoRespuesta<>(this.servicioGenerarCotizacion.ejecutar(cotizacion));
    }
}
