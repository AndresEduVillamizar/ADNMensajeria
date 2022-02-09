package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.dto.DtoUsuarioEnvio;
import com.ceiba.usuario.puerto.dao.DaoUsuariosEnvios;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoUsuariosEnvioMysql implements DaoUsuariosEnvios {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="envio", value="listarEnvio")
    private static String sqlListar;

    public DaoUsuariosEnvioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoUsuarioEnvio> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoUsuarioEnvio());
    }
}
