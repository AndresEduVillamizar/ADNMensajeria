package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Cotizacion;
import com.ceiba.usuario.puerto.repositorio.RepositorioCotizacion;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCotizacionMysql implements RepositorioCotizacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioCotizacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace="envio", value="listarPremium")
    private static String sqlListarPremium;

    @Override
    public Boolean isPremium(Cotizacion cotizacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", cotizacion.getIdUsuario());

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlListarPremium,paramSource, Boolean.class);
    }
}
