package com.example.fuerm.gestionoficinatecnica.Datos;

import android.util.Log;

import com.example.fuerm.gestionoficinatecnica.objetos.Cliente;
import com.example.fuerm.gestionoficinatecnica.objetos.Documento;
import com.example.fuerm.gestionoficinatecnica.objetos.Facturacion;
import com.example.fuerm.gestionoficinatecnica.objetos.Ficha;
import com.example.fuerm.gestionoficinatecnica.objetos.Obra;


import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by fuerm on 05/05/2017.
 */
/*
Clase que se encarga de cargar los datos del documento plan de emergencia para pruebas.
 */
public class CargaDatos {
    private  Map<String, Object> map;
    private Cliente cliente;
    private Facturacion facturacion;
    private Ficha ficha;
    private Obra obra;
    private Documento documento;
    private  String type; //Tipo de documento
    private JSONObject data; //Objeto JSON
    private String docId;//Identificador del proyecto
    private Date fecha_actual;


    //Constructor donde realizamos la carga en el Objeto map
    public CargaDatos(JSONObject data) throws JSONException {

        this.data = data;

        type = "plan_de_emergencia";

        fecha_actual = new Date();

        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");


        docId =
                data.getJSONObject("step1").getJSONArray("fields").getJSONObject(1).getString("value") + "." + UUID.randomUUID() + "---"+ formateador.format(fecha_actual);

        //(1)*********Cliente*********
        cliente = new Cliente();
        facturacion = new Facturacion();
        ficha = new Ficha();
        obra = new Obra();

        Log.d("app_oficinaTecnica",
                data.getJSONObject("step1").getJSONArray("fields").getJSONObject(1).getString("value"));

        cliente.setNombre(
                data.getJSONObject("step1").getJSONArray("fields").getJSONObject(1).getString("value"));
        cliente.setCif("42860010q");

        //Apellidos
        cliente.getApellidos().setPrimer_apellido(
                data.getJSONObject("step1").getJSONArray("fields").getJSONObject(2).getString("value"));
        cliente.getApellidos().setSegundo_apellido(
                data.getJSONObject("step1").getJSONArray("fields").getJSONObject(3).getString("value"));

        //***********Fin Cliente********

        //(2)**********Facturacion*********

        facturacion = new Facturacion();
        Facturacion.Factura factura = facturacion.getFactura();

        factura.setId_factura(
                data.getJSONObject("step2").getJSONArray("fields").getJSONObject(1).getString("value"));
        factura.setCif(
                data.getJSONObject("step2").getJSONArray("fields").getJSONObject(2).getString("value"));

        Facturacion.Factura.DireccionFacturacion direccionFacturacion = factura.getDireccionFacturacion();

        direccionFacturacion.setPais(
                data.getJSONObject("step2").getJSONArray("fields").getJSONObject(3).getString("value"));
        direccionFacturacion.setProvincia(
                data.getJSONObject("step2").getJSONArray("fields").getJSONObject(4).getString("value"));
        direccionFacturacion.setMunicipio(
                data.getJSONObject("step2").getJSONArray("fields").getJSONObject(5).getString("value"));
        direccionFacturacion.setCalle(
                data.getJSONObject("step2").getJSONArray("fields").getJSONObject(6).getString("value"));
        if(data.getJSONObject("step2").getJSONArray("fields").getJSONObject(7).getString("value").equals("")){
            direccionFacturacion.setCodigo_postal(00000);
        }else{
            direccionFacturacion.setCodigo_postal(Integer.parseInt(
                    data.getJSONObject("step2").getJSONArray("fields").getJSONObject(7).getString("value")));
        }


        //***********Fin Facturación*********

        //(3)*******Ficha***********************

        ficha = new Ficha();

        ficha.setLocalizacion(
                data.getJSONObject("step3").getJSONArray("fields").getJSONObject(1).getString("value"));
        if(data.getJSONObject("step3").getJSONArray("fields").getJSONObject(2).getString("value").equals("")){
            ficha.setNumero_participantes(0000);
        }else{
            ficha.setNumero_participantes(
                    Integer.parseInt(data.getJSONObject("step3").getJSONArray("fields").getJSONObject(2).getString("value")));
        }

        ficha.setPresencia_menores(Boolean.parseBoolean(
                data.getJSONObject("step3").getJSONArray("fields").getJSONObject(3).getJSONArray("options").getJSONObject(0).getString("value")));
        ficha.setAccesible_discapacitados(Boolean.parseBoolean(
                data.getJSONObject("step3").getJSONArray("fields").getJSONObject(3).getJSONArray("options").getJSONObject(1).getString("value")));
        ficha.setTipo_evento(
                data.getJSONObject("step3").getJSONArray("fields").getJSONObject(4).getString("value"));
        ficha.setHorario(
                data.getJSONObject("step3").getJSONArray("fields").getJSONObject(5).getString("value"));

        //Ambulancias

        //00
        Ficha.Ambulancia ambulancia = ficha.getAmbulancia();
        ambulancia.setMatricula(
                data.getJSONObject("step3").getJSONArray("fields").getJSONObject(6).getString("value"));
        ambulancia.setTipo(
                data.getJSONObject("step3").getJSONArray("fields").getJSONObject(7).getString("value"));

        ficha.setAmbulancia(ambulancia);
        /**
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
         **/

        ficha.setVenta_alcohol(Boolean.parseBoolean(
                data.getJSONObject("step3").getJSONArray("fields").getJSONObject(3).getJSONArray("options").getJSONObject(2).getString("value")));
        //Fin Ambulancias

        //Aseos


        //00
        Ficha.Aseo aseo = ficha.getAseo();
        aseo.setTipo(
                data.getJSONObject("step3").getJSONArray("fields").getJSONObject(8).getString("value"));
        aseo.setLocalizacion(
                data.getJSONObject("step3").getJSONArray("fields").getJSONObject(9).getString("value"));

        ficha.setAseo(aseo);


/**
        //01
        Ficha.Aseo aseo1 = ficha.getAseo();
        aseo1.setTipo("fijo");
        aseo1.setLocalizacion("localizacion01");
        ficha.setAseo(aseo1);


        ficha.setCortar_calles(true);
        //Fin Aseos

**/
        //Hinchables

        //00
        Ficha.Hinchable hinchable = ficha.getHinchable();
        hinchable.setTipo("tipo00");
        hinchable.setAnclajes(true);
        //Datos del responsable
        Ficha.DatosResponsable datosResponsable = hinchable.getDatosResponsable();
        datosResponsable.setCif("42860010q");
        datosResponsable.setTelefono_fijo(928888888);
        datosResponsable.setTelefono_movil(637777777);
        //Direccion del responsable
        Ficha.DatosResponsable.DireccionResponsable direccionResponsable = datosResponsable.getDireccionResponsable();
        direccionResponsable.setPais("pais");
        direccionResponsable.setProvincia("provincia");
        direccionResponsable.setMunicipio("municipio");
        direccionResponsable.setCalle("calle");
        direccionResponsable.setCodigo_postal(35600);
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
        //Medidas
        Ficha.Medidas medidas_carpa = carpa.getMedidas();
        medidas_carpa.setAlto(20);
        medidas_carpa.setAncho(20);
        medidas_carpa.setProfundo(20);
        //Datos del responsable
        Ficha.DatosResponsable datosResponsable_carpa = carpa.getDatosResponsable();
        //Direccion del responsable
        Ficha.DatosResponsable.DireccionResponsable  direccionResponsable_carpa = datosResponsable_carpa.getDireccionResponsable();
        direccionResponsable_carpa.setPais("pais0");
        direccionResponsable_carpa.setProvincia("provincia0");
        direccionResponsable_carpa.setMunicipio("municipio0");
        direccionResponsable_carpa.setCalle("calle0");
        direccionResponsable_carpa.setCodigo_postal(35600);
        datosResponsable_carpa.setCif("42860010q");
        datosResponsable_carpa.setTelefono_fijo(928888889);
        datosResponsable_carpa.setTelefono_movil(637777778);

        //Añadimos Carpa a la lista
        ficha.setCarpa(carpa);
        //*******Fin Carpas*****

        //(4)*******Obra***********

        obra = new Obra();
        obra.getDireccionObra().setPais(
                data.getJSONObject("step4").getJSONArray("fields").getJSONObject(1).getString("value"));
        obra.getDireccionObra().setProvincia(
                data.getJSONObject("step4").getJSONArray("fields").getJSONObject(2).getString("value"));
        obra.getDireccionObra().setMunicipio(
                data.getJSONObject("step4").getJSONArray("fields").getJSONObject(3).getString("value"));
        obra.getDireccionObra().setCalle(
                data.getJSONObject("step4").getJSONArray("fields").getJSONObject(4).getString("value"));
        if(data.getJSONObject("step4").getJSONArray("fields").getJSONObject(5).getString("value").equals("")){
            obra.getDireccionObra().setCodigo_postal(00000);
        }else{
            obra.getDireccionObra().setCodigo_postal(Integer.parseInt(
                    data.getJSONObject("step4").getJSONArray("fields").getJSONObject(5).getString("value")));
        }


        //*******Fin Obra*******

//**********************************************************************

        map = new HashMap<String, Object>();

        //*********Type**********
        map.put("type",type);

        //*********docId**********
        map.put("docId",docId);

        //**********Cliente***********
        map.put("nombre_cliente",cliente.getNombre());
        map.put("apellidos_cliente",cliente.getApellidos().getPrimer_apellido() + " " +
                cliente.getApellidos().getSegundo_apellido());
        map.put("cif_cliente",cliente.getCif());

        //*********Facturación**************
        map.put("id_factura", factura.getId_factura());
        map.put("pais_factura", direccionFacturacion.getPais());
        map.put("provincia_factura", direccionFacturacion.getProvincia());
        map.put("municipio_factura", direccionFacturacion.getMunicipio());
        map.put("calle_factura", direccionFacturacion.getCalle());
        map.put("cp_factura", direccionFacturacion.getCodigo_postal());

        //*******Ficha***************
        map.put("localizacion_ficha", ficha.getLocalizacion());
        map.put("numeroParticipantes_ficha", ficha.getNumero_participantes());
        map.put("presenciaMenores_ficha", ficha.isPresencia_menores());
        map.put("tipoEvento_ficha",ficha.getTipo_evento());
        map.put("horario_ficha",ficha.getHorario());
        //Ambulancias
        for (Ficha.Ambulancia iter_ambulancia : ficha.getAmbulancias()) {
            map.put("matricula_ambulancia",iter_ambulancia.getMatricula());
            map.put("tipo_ambulancia",iter_ambulancia.getTipo());
        }
        map.put("ventaAlcohol_ficha",ficha.isVenta_alcohol());
        //Aseos
        for (Ficha.Aseo iter_aseo : ficha.getAseos()) {
            map.put("tipo_aseo",iter_aseo.getTipo());
            map.put("localizacion_aseo",iter_aseo.getLocalizacion());
        }
        //Hinchables
        for (Ficha.Hinchable iter_hinchable : ficha.getHinchables()) {
            map.put("tipo_hinchable",iter_hinchable.getTipo());
            map.put("anclajes_hinchable",iter_hinchable.isAnclajes());
            map.put("cifResponsable_hinchable",iter_hinchable.getDatosResponsable().getCif());
            map.put("telefonoFijo_hinchable",iter_hinchable.getDatosResponsable().getTelefono_fijo());
            map.put("telefonoMovil_hinchable",iter_hinchable.getDatosResponsable().getTelefono_movil());
            map.put("pais_responsableHinchable",iter_hinchable.getDatosResponsable().getDireccionResponsable().getPais());
            map.put("provincia_responsableHinchable",iter_hinchable.getDatosResponsable().getDireccionResponsable().getProvincia());
            map.put("municipio_responsableHinchable",iter_hinchable.getDatosResponsable().getDireccionResponsable().getMunicipio());
            map.put("calle_responsableHinchable",iter_hinchable.getDatosResponsable().getDireccionResponsable().getCalle());
            map.put("cp_responsableHinchable",iter_hinchable.getDatosResponsable().getDireccionResponsable().getCodigo_postal());
            map.put("alto_hinchable",iter_hinchable.getMedidas().getAlto());
            map.put("ancho_hinchable",iter_hinchable.getMedidas().getAncho());
            map.put("profundidad_hinchable",iter_hinchable.getMedidas().getProfundo());
        }
        //Carpas
        for (Ficha.Carpa iter_carpa : ficha.getCarpas()) {
            map.put("modelo_carpa",iter_carpa.getModelo());
            map.put("anclajes_carpa",iter_carpa.isAnclajes());
            map.put("alto_carpa",iter_carpa.getMedidas().getAlto());
            map.put("ancho_carpa",iter_carpa.getMedidas().getAncho());
            map.put("profundo_carpa",iter_carpa.getMedidas().getProfundo());
            map.put("pais_responsableCarpa",iter_carpa.getDatosResponsable().getDireccionResponsable().getPais());
            map.put("provincia_responsableCarpa",iter_carpa.getDatosResponsable().getDireccionResponsable().getProvincia());
            map.put("municipio_responsableCarpa",iter_carpa.getDatosResponsable().getDireccionResponsable().getMunicipio());
            map.put("calle_responsableCarpa",iter_carpa.getDatosResponsable().getDireccionResponsable().getCalle());
            map.put("cp_responsableCarpa",iter_carpa.getDatosResponsable().getDireccionResponsable().getCodigo_postal());
            map.put("cif_responsableCarpa",iter_carpa.getDatosResponsable().getCif());
            map.put("telefonoFijo_responsableCarpa",iter_carpa.getDatosResponsable().getTelefono_fijo());
            map.put("telefonoMovil_responsableCarpa",iter_carpa.getDatosResponsable().getTelefono_movil());
        }
        //Obra
        map.put("pais_obra",obra.getDireccionObra().getPais());
        map.put("provincia_obra",obra.getDireccionObra().getProvincia());
        map.put("municipio_obra",obra.getDireccionObra().getMunicipio());
        map.put("calle_obra",obra.getDireccionObra().getCalle());
        map.put("cp_obra",obra.getDireccionObra().getCodigo_postal());

    }

    public Map<String, Object> getMap() {
        return map;
    }
}
