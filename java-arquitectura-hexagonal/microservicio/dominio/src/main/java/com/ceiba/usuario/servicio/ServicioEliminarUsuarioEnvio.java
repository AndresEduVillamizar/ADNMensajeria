package com.ceiba.usuario.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuarioEnvio;

public class ServicioEliminarUsuarioEnvio {

    private final RepositorioUsuarioEnvio repositorioUsuarioEnvio;

    public ServicioEliminarUsuarioEnvio(RepositorioUsuarioEnvio repositorioUsuarioEnvio) {
        this.repositorioUsuarioEnvio = repositorioUsuarioEnvio;
    }

    public void ejecutar(Long id){
        this.repositorioUsuarioEnvio.eliminar(id);
    }


}
