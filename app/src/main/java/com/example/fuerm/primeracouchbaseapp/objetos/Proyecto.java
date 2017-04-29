package com.example.fuerm.primeracouchbaseapp.objetos;

/**
 * Created by fuerm on 27/04/2017.
 */

public class Proyecto {
    private String _id;//todo mirar si esta variable es la interna automatica(nosotros haremos una personalizada)
    private String tipo;//tipo de documento.
    private Cliente cliente;
    private Ficha ficha;
    private Obra obra;
    private Facturacion facturacion;

    public Proyecto() {
    }

    public Proyecto(String _id, String tipo, Cliente cliente, Ficha ficha, Obra obra,
                    Facturacion facturacion) {
        this._id = _id;
        this.tipo = tipo;
        this.cliente = cliente;
        this.ficha = ficha;
        this.obra = obra;
        this.facturacion = facturacion;
    }
}
