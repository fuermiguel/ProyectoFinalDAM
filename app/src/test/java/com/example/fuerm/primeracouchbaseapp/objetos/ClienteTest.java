package com.example.fuerm.primeracouchbaseapp.objetos;

//Test de introducir datos y posteriormente leerlos de los objetos usados en los documentos*/


import org.junit.Test;
import org.junit.Assert;//Este es el que usamos en JUnit4
import static org.hamcrest.Matchers.is;//Lo usamos en combinación con Assert.assertThat



/**
 * Created by fuerm on 01/05/2017.
 */
public class ClienteTest {

    @Test
    public void Cliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Miguel");
        cliente.setCif("42860010q");
        cliente.getApellidos().setPrimer_apellido("Gonzalez");
        cliente.getApellidos().setSegundo_apellido("Canales");
        Assert.assertEquals("Miguel",cliente.getNombre());
        Assert.assertEquals("42860010q",cliente.getCif());
        Assert.assertThat("Miguel",is(cliente.getNombre()));
        Assert.assertThat("Gonzalez Canales", is(cliente.getApellidos().getPrimer_apellido() + " " +
        cliente.getApellidos().getSegundo_apellido()));
    }

}