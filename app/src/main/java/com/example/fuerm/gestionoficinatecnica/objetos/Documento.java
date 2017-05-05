package com.example.fuerm.gestionoficinatecnica.objetos;

/**
 * Created by fuerm on 27/04/2017.
 */

public class Documento {
    private String _id;//todo mirar si esta variable es la interna automatica(nosotros haremos una personalizada)
    private String tipo;//tipo de documento.


    public Documento() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
