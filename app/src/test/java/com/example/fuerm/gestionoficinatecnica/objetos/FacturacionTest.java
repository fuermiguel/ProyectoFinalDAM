package com.example.fuerm.gestionoficinatecnica.objetos;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

/**
 * Created by fuerm on 02/05/2017.
 */

public class FacturacionTest {
    @Test
    public void Facturacion() {
        Facturacion facturacion = new Facturacion();
        Facturacion.Factura factura = facturacion.getFactura();

        factura.setId_factura("1A");
        factura.setCif("42860010q");

        Facturacion.Factura.DireccionFacturacion direccionFacturacion = factura.getDireccionFacturacion();

        direccionFacturacion.setPais("pais");
        direccionFacturacion.setProvincia("provincia");
        direccionFacturacion.setMunicipio("municipio");
        direccionFacturacion.setCalle("calle");
        direccionFacturacion.setCodigo_postal(35600);




        //Una manera de hacer el test (uno a uno)
        Assert.assertEquals("1A",factura.getId_factura());
        Assert.assertEquals("42860010q",factura.getCif());
        Assert.assertEquals("calle",factura.getDireccionFacturacion().getCalle());

        //Otra manera de hacer el test
        Assert.assertThat("pais provincia municipio calle 35600",
                is(direccionFacturacion.getPais() + " " +
                        direccionFacturacion.getProvincia() + " " +
                        direccionFacturacion.getMunicipio() + " " +
                        direccionFacturacion.getCalle()+ " " +
                        direccionFacturacion.getCodigo_postal()));

    }
}
