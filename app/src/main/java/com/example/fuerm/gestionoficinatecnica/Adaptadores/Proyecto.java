package com.example.fuerm.gestionoficinatecnica.Adaptadores;


import com.example.fuerm.gestionoficinatecnica.R;

public class Proyecto {
    private String nombre;
    private int idDrawable;

    public Proyecto(String nombre, int idDrawable) {
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public void setIdDrawable(int idDrawable) {
        this.idDrawable = idDrawable;
    }

    public static Proyecto[] Proyectos = {
            new Proyecto("Plan de emergencia", R.drawable.plan_de_emergencia),
            new Proyecto("Ejecución vaso piscina", R.drawable.piscina),
            new Proyecto("Reclamación catastral", R.drawable.reclamacion_catastral),
            new Proyecto("Vallado solar", R.drawable.reforma),
            new Proyecto("Planos vivienda", R.drawable.planos_vivienda),
            new Proyecto("Vivienda vacacional", R.drawable.vivienda_vacacional),
            new Proyecto("Certificado energético", R.drawable.certificado_energetico),
            new Proyecto("Reforma", R.drawable.reforma),

    };

    public static Proyecto getProyecto(int id){
        for (Proyecto proyecto: Proyectos){
            if (proyecto.getIdDrawable() == id){
                return  proyecto;
            }
        }
        return null;

    }
}
