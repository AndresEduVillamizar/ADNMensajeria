package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Cotizacion {

    private final String NO_SUPERA_DISTANCIA_MINIMA="Se requiere una distancia minima de 5";
    private final String SUPERA_DISTANCIA_MAXIMA="Se sobrepaso el maximo de distancia el cual es de 40";
    private final String SE_REQUIERE_DISTANCIA = "Se requiere ingresar la distancia";
    private final String SE_REQUIERE_ID_USUARIO = "Se requiere ingresar un id Usuario";

    private final float DISTANCIA_MINIMA = 5;
    private final float DISTANCIA_MAXIMA = 40;

    private Long idUsuario;
    private float distanciaRecorrido;

    public Cotizacion(Long idUsuario, float distanciaRecorrido) {

        validarDatoIdUsuario(idUsuario,SE_REQUIERE_ID_USUARIO);
        validarObligatorioDistancia(distanciaRecorrido, SE_REQUIERE_DISTANCIA);
        validarDistanciaMinima(distanciaRecorrido, DISTANCIA_MINIMA, NO_SUPERA_DISTANCIA_MINIMA);
        validarDistanciaMaxima(distanciaRecorrido, DISTANCIA_MAXIMA, SUPERA_DISTANCIA_MAXIMA);

        this.idUsuario = idUsuario;
        this.distanciaRecorrido=distanciaRecorrido;
    }
}
