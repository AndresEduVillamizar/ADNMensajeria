package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuarioEnvio;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoUsuarioEnvio implements RowMapper<DtoUsuarioEnvio>, MapperResult {
    
    @Override
    public DtoUsuarioEnvio mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        boolean premium = resultSet.getBoolean("premium");

        return new DtoUsuarioEnvio(id,nombre,premium);
    }
}
