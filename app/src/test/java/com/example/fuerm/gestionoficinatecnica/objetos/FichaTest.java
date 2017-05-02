package com.example.fuerm.gestionoficinatecnica.objetos;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

/**
 * Created by fuerm on 02/05/2017.
 */

public class FichaTest {
    @Test
    public void Ficha() {
        Ficha ficha = new Ficha();

        ficha.setAccesible_discapacitados(true);
        Ficha.Ambulancias ambulancias = ficha.getAmbulancia();
        ambulancias.setTipo("medicalizada");
        ambulancias.setPresencia(true);

        ficha.setAseos();
        ficha.setCarpas();
        ficha.setCortar_calles();
        ficha.setHinchables();
        ficha.setHorario();
        ficha.setLocalizacion();
        ficha.setNumero_aseos();
        ficha.setNumero_carpas();
        ficha.setNumero_inchables();
        ficha.setNumero_participantes();
        ficha.setPresencia_menores();
        ficha.setTipo_evento();
        ficha.setVenta_alcohol();


        //Una manera de hacer el test (uno a uno)
        Assert.assertEquals("calle", obra.getDireccionObra().getCalle());

        //Otra manera de hacer el test
        Assert.assertThat("pais provincia municipio calle 35600",
                is(obra.getDireccionObra().getPais() + " " +
                        obra.getDireccionObra().getProvincia() + " " +
                        obra.getDireccionObra().getMunicipio() + " " +
                        obra.getDireccionObra().getCalle() + " " +
                        obra.getDireccionObra().getCodigo_postal()));
    }
}
