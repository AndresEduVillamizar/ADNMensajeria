package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioCotizacion;
import com.ceiba.usuario.servicio.ServicioGenerarCotizacion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioCotizacion {

    @Bean
    public ServicioGenerarCotizacion servicioCrearMensajeria(RepositorioCotizacion repositorioCotizacion){
        return new ServicioGenerarCotizacion(repositorioCotizacion);
    }
}
