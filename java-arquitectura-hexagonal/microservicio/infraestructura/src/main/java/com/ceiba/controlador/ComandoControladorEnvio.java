package com.ceiba.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoEnvio;
import com.ceiba.usuario.comando.ComandoCotizacion;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuarioEnvio;
import com.ceiba.usuario.comando.manejador.ManejadorGeneradorCotizacion;
import com.ceiba.usuario.comando.manejador.ManejadorEliminarUsuarioEnvio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/envios")
@Api(tags = { "Controlador comando envios"})
public class ComandoControladorEnvio {

    private final ManejadorCrearUsuarioEnvio manejadorCrearUsuarioEnvio;
    private final ManejadorGeneradorCotizacion manejadorGeneradorCotizacion;
    private final ManejadorEliminarUsuarioEnvio manejadorEliminarUsuarioEnvio;

    @Autowired
    public ComandoControladorEnvio(ManejadorCrearUsuarioEnvio manejadorCrearUsuarioEnvio, ManejadorGeneradorCotizacion manejadorGeneradorCotizacion, ManejadorEliminarUsuarioEnvio manejadorEliminarUsuarioEnvio) {
        this.manejadorCrearUsuarioEnvio = manejadorCrearUsuarioEnvio;
        this.manejadorGeneradorCotizacion = manejadorGeneradorCotizacion;
        this.manejadorEliminarUsuarioEnvio = manejadorEliminarUsuarioEnvio;
    }

    @PostMapping
    @ApiOperation("Crear Mensajeria")
    public ComandoRespuesta<Double> generarCotizacion(@RequestBody ComandoCotizacion comandoCotizacion) {
        return manejadorGeneradorCotizacion.ejecutar(comandoCotizacion);
    }

    @DeleteMapping
    @ApiOperation("Eliminar Usuario Envio")
    public void eliminarUsuario(@RequestParam("id") Long id){
        manejadorEliminarUsuarioEnvio.ejecutar(id);
    }

    @PostMapping("/registro")
    @ApiOperation("Crear Usuario")
    public ComandoRespuesta<Long> crearUsuario(@RequestBody ComandoEnvio comandoEnvio) {
        return manejadorCrearUsuarioEnvio.ejecutar(comandoEnvio);
    }
}
