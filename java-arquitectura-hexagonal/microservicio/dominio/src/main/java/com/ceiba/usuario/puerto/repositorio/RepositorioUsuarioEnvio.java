package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.UsuarioEnvio;

public interface RepositorioUsuarioEnvio {

    /**
     * Permite crear un usuario
     * @param usuarioEnvio
     * @return el id generado
     */
    Long crear(UsuarioEnvio usuarioEnvio);

    boolean existe(String nombre);

    void eliminar(Long id);
}
