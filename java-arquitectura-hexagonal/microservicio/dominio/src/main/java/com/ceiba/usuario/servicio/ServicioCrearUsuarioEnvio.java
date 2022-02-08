package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.UsuarioEnvio;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuarioEnvio;

public class ServicioCrearUsuarioEnvio {

    private final String SE_ENCUENTRA_REGISTRADO="Nombre de usuario se encuentra registrado";

    private final RepositorioUsuarioEnvio repositorioUsuarioEnvio;

    public ServicioCrearUsuarioEnvio(RepositorioUsuarioEnvio repositorioUsuarioEnvio) {
        this.repositorioUsuarioEnvio = repositorioUsuarioEnvio;
    }

    public Long ejecutar(UsuarioEnvio usuarioEnvio) {
        existeUsuario(usuarioEnvio.getNombre());
        return this.repositorioUsuarioEnvio.crear(usuarioEnvio);
    }

    public void existeUsuario(String nombre){
        if(repositorioUsuarioEnvio.existe(nombre)){
            throw new ExcepcionDuplicidad(SE_ENCUENTRA_REGISTRADO);
        }
    }
}
