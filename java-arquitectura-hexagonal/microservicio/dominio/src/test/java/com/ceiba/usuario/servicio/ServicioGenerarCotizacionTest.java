package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Cotizacion;
import com.ceiba.usuario.puerto.repositorio.RepositorioCotizacion;
import com.ceiba.usuario.servicio.testdatabuilder.CotizacionTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

public class ServicioGenerarCotizacionTest {

    @Test
    void deberiaGenerarUnaCotizacionCorrectamenteNoPremiumNoFindeSemana(){

        Cotizacion cotizacion = new CotizacionTestDataBuilder().build();
        RepositorioCotizacion repositorioCotizacion = Mockito.mock(RepositorioCotizacion.class);
        //Se indica no premium
        Mockito.when(repositorioCotizacion.isPremium(cotizacion)).thenReturn(false);

        ServicioGenerarCotizacion servicioGenerarCotizacion = spy(new ServicioGenerarCotizacion(repositorioCotizacion));
        //Se indica que es fin de semana
        Mockito.when(servicioGenerarCotizacion.isFinSemana()).thenReturn(false);

        Double precioCotizacion = servicioGenerarCotizacion.ejecutar(cotizacion);

        assertEquals(20 * 1000, precioCotizacion);

    }

    @Test
    void deberiaGenerarUnaCotizacionCorrectamenteNoPremiumSiFindeSemana(){

        Cotizacion cotizacion = new CotizacionTestDataBuilder().build();
        RepositorioCotizacion repositorioCotizacion = Mockito.mock(RepositorioCotizacion.class);
        //Se indica no premium
        Mockito.when(repositorioCotizacion.isPremium(cotizacion)).thenReturn(false);

        ServicioGenerarCotizacion servicioGenerarCotizacion = spy(new ServicioGenerarCotizacion(repositorioCotizacion));
        //Se indica que es fin de semana
        Mockito.when(servicioGenerarCotizacion.isFinSemana()).thenReturn(true);

        Double precioCotizacion = servicioGenerarCotizacion.ejecutar(cotizacion);

        assertEquals(20 * 1500, precioCotizacion);

    }

    @Test
    void deberiaGenerarUnaCotizacionCorrectamenteSiPremiumNoFindeSemana(){

        Cotizacion cotizacion = new CotizacionTestDataBuilder().build();
        RepositorioCotizacion repositorioCotizacion = Mockito.mock(RepositorioCotizacion.class);
        //Se indica no premium
        Mockito.when(repositorioCotizacion.isPremium(cotizacion)).thenReturn(true);

        ServicioGenerarCotizacion servicioGenerarCotizacion = spy(new ServicioGenerarCotizacion(repositorioCotizacion));
        //Se indica que es fin de semana
        Mockito.when(servicioGenerarCotizacion.isFinSemana()).thenReturn(false);

        Double precioCotizacion = servicioGenerarCotizacion.ejecutar(cotizacion);

        assertEquals(20 * 1000 * 0.75, precioCotizacion);

    }

    @Test
    void deberiaGenerarUnaCotizacionCorrectamenteSiPremiumSiFindeSemana(){

        Cotizacion cotizacion = new CotizacionTestDataBuilder().build();
        RepositorioCotizacion repositorioCotizacion = Mockito.mock(RepositorioCotizacion.class);
        //Se indica no premium
        Mockito.when(repositorioCotizacion.isPremium(cotizacion)).thenReturn(true);

        ServicioGenerarCotizacion servicioGenerarCotizacion = spy(new ServicioGenerarCotizacion(repositorioCotizacion));
        //Se indica que es fin de semana
        Mockito.when(servicioGenerarCotizacion.isFinSemana()).thenReturn(true);

        Double precioCotizacion = servicioGenerarCotizacion.ejecutar(cotizacion);

        assertEquals(20 * 1500 * 0.75, precioCotizacion);

    }
}
