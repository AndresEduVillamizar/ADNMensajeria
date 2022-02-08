package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuarioEnvio;
import com.ceiba.usuario.servicio.ServicioCrearUsuarioEnvio;
import com.ceiba.usuario.servicio.ServicioEliminarUsuarioEnvio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioUsuarioEnvio {

    @Bean
    public ServicioCrearUsuarioEnvio servicioCrearUsuarioEnvio(RepositorioUsuarioEnvio repositorioUsuarioEnvio) {
        return new ServicioCrearUsuarioEnvio(repositorioUsuarioEnvio);
    }

    @Bean
    public ServicioEliminarUsuarioEnvio servicioEliminarUsuarioEnvio(RepositorioUsuarioEnvio repositorioUsuarioEnvio){
        return new ServicioEliminarUsuarioEnvio(repositorioUsuarioEnvio);
    }

}
