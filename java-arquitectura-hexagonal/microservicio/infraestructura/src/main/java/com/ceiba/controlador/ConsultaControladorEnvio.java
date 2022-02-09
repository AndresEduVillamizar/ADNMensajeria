package com.ceiba.controlador;

import com.ceiba.usuario.consulta.ManejadorListarUsuariosEnvios;
import com.ceiba.usuario.modelo.dto.DtoUsuarioEnvio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/envios")
@Api(tags={"Controlador consulta usuarios registrados"})
public class ConsultaControladorEnvio {

    private final ManejadorListarUsuariosEnvios manejadorListarUsuariosEnvios;

    public ConsultaControladorEnvio(ManejadorListarUsuariosEnvios manejadorListarUsuariosEnvios) {
        this.manejadorListarUsuariosEnvios = manejadorListarUsuariosEnvios;
    }

    @GetMapping
    @ApiOperation("Listar Usuarios")
    public List<DtoUsuarioEnvio> listar() {
        return this.manejadorListarUsuariosEnvios.ejecutar();
    }
}
