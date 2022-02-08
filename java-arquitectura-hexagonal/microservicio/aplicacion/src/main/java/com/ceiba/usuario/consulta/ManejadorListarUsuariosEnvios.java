package com.ceiba.usuario.consulta;

import com.ceiba.usuario.modelo.dto.DtoUsuarioEnvio;
import com.ceiba.usuario.puerto.dao.DaoUsuariosEnvios;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class ManejadorListarUsuariosEnvios {

    private final DaoUsuariosEnvios daoUsuariosEnvios;

    public ManejadorListarUsuariosEnvios(DaoUsuariosEnvios daoUsuariosEnvios){
        this.daoUsuariosEnvios = daoUsuariosEnvios;
    }

    public List<DtoUsuarioEnvio> ejecutar(){ return this.daoUsuariosEnvios.listar(); }
}
