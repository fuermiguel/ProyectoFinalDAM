package com.example.fuerm.gestionoficinatecnica.objetos;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

/**
 * Created by fuerm on 02/05/2017.
 */

public class ObraTest {
    @Test
    public void Obra() {
        Obra obra = new Obra();
        obra.getDireccionObra().setCalle("calle");
        obra.getDireccionObra().setCodigo_postal(35600);
        obra.getDireccionObra().setMunicipio("municipio");
        obra.getDireccionObra().setPais("pais");
        obra.getDireccionObra().setProvincia("provincia");

       //Una manera de hacer el test (uno a uno)
        Assert.assertEquals("calle",obra.getDireccionObra().getCalle());

        //Otra manera de hacer el test
        Assert.assertThat("pais provincia municipio calle 35600",
                is(obra.getDireccionObra().getPais() + " " +
                        obra.getDireccionObra().getProvincia() + " " +
                        obra.getDireccionObra().getMunicipio() + " " +
                        obra.getDireccionObra().getCalle()+ " " +
                        obra.getDireccionObra().getCodigo_postal()));

    }
}

