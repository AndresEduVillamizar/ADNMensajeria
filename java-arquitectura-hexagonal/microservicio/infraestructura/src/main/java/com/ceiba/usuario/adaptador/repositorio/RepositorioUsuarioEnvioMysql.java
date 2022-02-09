package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.UsuarioEnvio;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuarioEnvio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarioEnvioMysql implements RepositorioUsuarioEnvio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="envio", value="crearEnvio")
    private static String sqlCrear;

    @SqlStatement(namespace="envio", value="existeEnvio")
    private static String sqlExiste;

    @SqlStatement(namespace="envio", value="eliminarEnvio")
    private static String sqlEliminar;

    public RepositorioUsuarioEnvioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(UsuarioEnvio usuarioEnvio) {
        return this.customNamedParameterJdbcTemplate.crear(usuarioEnvio, sqlCrear);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }
}
