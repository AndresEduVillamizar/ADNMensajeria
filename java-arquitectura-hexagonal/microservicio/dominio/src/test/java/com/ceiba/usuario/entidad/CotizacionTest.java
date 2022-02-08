package com.ceiba.usuario.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.modelo.entidad.Cotizacion;
import com.ceiba.usuario.servicio.testdatabuilder.CotizacionTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CotizacionTest {

    @Test
    void deberiaCrearLaCotizacionCorrectamente() {
        Cotizacion cotizacion = new CotizacionTestDataBuilder()
                .conDistanciaRecorrido(25)
                .conIdUsuario(1L)
                .build();

        assertEquals(1, cotizacion.getId());
        assertEquals(25, cotizacion.getDistanciaRecorrido());
    }

    @Test
    void DeberiaFallarPorId() {
        CotizacionTestDataBuilder cotizacionTestDataBuilder = new CotizacionTestDataBuilder()
                .conDistanciaRecorrido(25)
                .conIdUsuario(0L);
        BasePrueba.assertThrows(() -> {
                    cotizacionTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se requiere ingresar un id Usuario");

    }

    @Test
    void deberiaFallarPorDistanciaRecorridaSuperior() {
        CotizacionTestDataBuilder cotizacionTestDataBuilder = new CotizacionTestDataBuilder()
                .conDistanciaRecorrido(41)
                .conIdUsuario(1L);
        BasePrueba.assertThrows(() -> {
                    cotizacionTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se sobrepaso el maximo de distancia el cual es de 40");

    }

    @Test
    void deberiaFallarPorDistanciaRecorridaInferior() {
        CotizacionTestDataBuilder cotizacionTestDataBuilder = new CotizacionTestDataBuilder()
                .conDistanciaRecorrido(4)
                .conIdUsuario(1L);
        BasePrueba.assertThrows(() -> {
                    cotizacionTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se requiere una distancia minima de 5");

    }

}
