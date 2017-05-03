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

        ficha.setLocalizacion("localizacion");
        ficha.setNumero_participantes(100);
        ficha.setPresencia_menores(true);
        ficha.setAccesible_discapacitados(true);
        ficha.setTipo_evento("festivo");
        ficha.setHorario("de 10:00 a 11:00");

        //Ambulancias

        //00
        Ficha.Ambulancia ambulancia = ficha.getAmbulancia();
        ambulancia.setMatricula("0000A");
        ambulancia.setTipo("medicalizada");
        ficha.setAmbulancia(ambulancia);
        //01
        Ficha.Ambulancia ambulancia1 = ficha.getAmbulancia();
        ambulancia1.setMatricula("0001A");
        ambulancia1.setTipo("normal");
        ficha.setAmbulancia(ambulancia1);
        //02
        Ficha.Ambulancia ambulancia2 = ficha.getAmbulancia();
        ambulancia2.setMatricula("0002A");
        ambulancia2.setTipo("medicalizada");
        ficha.setAmbulancia(ambulancia2);

        ficha.setVenta_alcohol(false);
        //Fin Ambulancias

        //Aseos

        //00
        Ficha.Aseo aseo = ficha.getAseo();
        aseo.setTipo("portatil");
        aseo.setLocalizacion("localizacion00");
        ficha.setAseo(aseo);

        //01
        Ficha.Aseo aseo1 = ficha.getAseo();
        aseo1.setTipo("fijo");
        aseo1.setLocalizacion("localizacion01");
        ficha.setAseo(aseo1);


        ficha.setCortar_calles(true);
        //Fin Aseos

        //Hinchables

        //00
        Ficha.Hinchable hinchable = ficha.getHinchable();
        hinchable.setTipo("tipo00");
        hinchable.setAnclajes(true);
        //Datos del responsable
        Ficha.DatosResponsable datosResponsable = hinchable.getDatosResponsable();
        //Direccion del responsable
        Ficha.DatosResponsable.DireccionResponsable direccionResponsable = datosResponsable.getDireccionResponsable();
        direccionResponsable.setPais("pais");
        direccionResponsable.setProvincia("provincia");
        direccionResponsable.setMunicipio("municipio");
        direccionResponsable.setCalle("calle");
        direccionResponsable.setCodigo_postal(35600);
        datosResponsable.setCif("42860010q");
        datosResponsable.setTelefono_fijo(928888888);
        datosResponsable.setTelefono_movil(637777777);
        //Medidas
        Ficha.Medidas medidas = hinchable.getMedidas();
        medidas.setAlto(10);
        medidas.setAncho(10);
        medidas.setProfundo(10);
        //Añadimos el hinchable a la lista
        ficha.setHinchable(hinchable);
        //Fin Hinchables

        //Carpas

        //00
        Ficha.Carpa carpa = ficha.getCarpa();
        carpa.setModelo("modelo");
        carpa.setAnclajes(true);
        Ficha.Medidas medidas_carpa = carpa.getMedidas();
        medidas_carpa.setAlto(20);
        medidas_carpa.setAncho(20);
        medidas_carpa.setProfundo(20);
        //Datos del responsable
        Ficha.DatosResponsable datosResponsable_carpa = hinchable.getDatosResponsable();
        //Direccion del responsable
        Ficha.DatosResponsable.DireccionResponsable  direccionResponsable_carpa = datosResponsable.getDireccionResponsable();
        direccionResponsable_carpa.setPais("pais");
        direccionResponsable_carpa.setProvincia("provincia");
        direccionResponsable_carpa.setMunicipio("municipio");
        direccionResponsable_carpa.setCalle("calle");
        direccionResponsable_carpa.setCodigo_postal(35600);
        datosResponsable_carpa.setCif("42860010q");
        datosResponsable_carpa.setTelefono_fijo(928888888);
        datosResponsable_carpa.setTelefono_movil(637777777);
        //Añadimos Carpa a la lista
        ficha.setCarpa(carpa);
        //Fin Carpas

        //**********Comenzamos con los Assert*********

        Assert.assertEquals("localizacion",ficha.getLocalizacion());
        Assert.assertEquals(100,ficha.getNumero_participantes());
        Assert.assertEquals(true,ficha.isPresencia_menores());
        Assert.assertEquals(true,ficha.isAccesible_discapacitados());
        Assert.assertEquals("festivo",ficha.getTipo_evento());
        Assert.assertEquals("de 10:00 a 11:00",ficha.getHorario());


        //Ambulancias
        int cnt_ambulancia = 0;
        for (Ficha.Ambulancia iter_ambulancia : ficha.getAmbulancias()) {
            switch (cnt_ambulancia) {
                case 0:
                    Assert.assertThat("0000A medicalizada" ,
                            is(iter_ambulancia.getMatricula() + " " +
                                    iter_ambulancia.getTipo()));

                    break;
                case 1:
                    Assert.assertThat("0001A normal" ,
                            is(iter_ambulancia.getMatricula() + " " +
                                    iter_ambulancia.getTipo()));

                    break;

                case 2:
                    Assert.assertThat("0002A medicalizada" ,
                            is(iter_ambulancia.getMatricula() + " " +
                                    iter_ambulancia.getTipo()));

            }
            cnt_ambulancia++;
        }
        //Fin Ambulancias

        Assert.assertEquals(false,ficha.isVenta_alcohol());

        //Aseos
        int cnt_aseo = 0;
        for (Ficha.Aseo iter_aseo : ficha.getAseos()) {
            switch (cnt_aseo) {
                case 0:
                    Assert.assertThat("portatil localizacion00" ,
                            is(iter_aseo.getTipo() + " " +
                                    iter_aseo.getLocalizacion()));

                    break;
                case 1:
                    Assert.assertThat("fijo localizacion01" ,
                            is(iter_aseo.getTipo() + " " +
                                    iter_aseo.getLocalizacion()));

                    break;
            }
            cnt_aseo++;
        }

        //Hinchables

        //Carpas
    }
}
