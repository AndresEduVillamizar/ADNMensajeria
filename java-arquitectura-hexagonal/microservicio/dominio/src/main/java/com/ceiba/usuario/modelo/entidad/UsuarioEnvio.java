package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class UsuarioEnvio {

    private final String SE_DEBE_INGRESAR_NOMBRE= "Se requiere ingresar el nombre del usuario";
    private final String SE_REQUIERE_CONTRASENA = "Se requiere ingresar un contraseña";

    private Long id;
    private String nombre;
    private String clave;
    private boolean premium;

    public UsuarioEnvio(Long id, String nombre, String clave, boolean premium) {

        validarObligatorio(nombre,SE_DEBE_INGRESAR_NOMBRE);
        validarObligatorio(clave,SE_REQUIERE_CONTRASENA);

        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.premium = premium;
    }
}
