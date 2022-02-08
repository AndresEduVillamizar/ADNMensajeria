package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Cotizacion;
import com.ceiba.usuario.puerto.repositorio.RepositorioCotizacion;

import java.util.Calendar;

public class ServicioGenerarCotizacion {

    private final RepositorioCotizacion repositorioCotizacion;

    private final int VALOR_FIN_DE_SEMANA = 1500;
    private final int VALOR_NO_FIN_DE_SEMANA = 1000;
    private final double DESCUENTO_PREMIUM = 0.75;


    public ServicioGenerarCotizacion(RepositorioCotizacion repositorioCotizacion) {
        this.repositorioCotizacion = repositorioCotizacion;
    }

    public Double ejecutar(Cotizacion cotizacion){
        boolean isPremium = isPremium(cotizacion);
        boolean isFinSemana = isFinSemana();
        return generarCotizacion(isPremium, cotizacion, isFinSemana);
    }
    public boolean isPremium(Cotizacion cotizacion){
        return this.repositorioCotizacion.isPremium(cotizacion);
    }

    public Double generarCotizacion(boolean isPremium, Cotizacion cotizacion, boolean isFinSemana){
        double valor = 0;
        if(isFinSemana){
            valor = ( (cotizacion.getDistanciaRecorrido()) * VALOR_FIN_DE_SEMANA);
        }else{
            valor = ( (cotizacion.getDistanciaRecorrido()) * VALOR_NO_FIN_DE_SEMANA);
        }
        valor = (isPremium) ? (valor * DESCUENTO_PREMIUM) : valor;
        return valor;
    }

    public boolean isFinSemana(){
        boolean isFinSemana = false;
        Calendar calendar = Calendar.getInstance();
        int numeroDia = calendar.get(Calendar.DAY_OF_WEEK);
        if((numeroDia == 1) ||(numeroDia==7)){
            isFinSemana = !isFinSemana;
        }
        return isFinSemana;
    }
}
