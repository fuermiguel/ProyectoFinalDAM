package com.example.fuerm.gestionoficinatecnica.objetos;

/**
 * Created by fuerm on 27/04/2017.
 */

public class Obra {
    private DireccionObra direccionObra =  new DireccionObra();

    public Obra() {
    }

    public Obra(DireccionObra direccionObra) {
        this.direccionObra = direccionObra;
    }

    public DireccionObra getDireccionObra() {
        return direccionObra;
    }

    public void setDireccionObra(DireccionObra direccionObra) {
        this.direccionObra = direccionObra;
    }

    class DireccionObra{
        private String pais;
        private String provincia;
        private String municipio;
        private String calle;
        private int codigo_postal;

        public DireccionObra() {
        }

        public DireccionObra(String pais, String provincia, String municipio, String calle, int codigo_postal) {
            this.pais = pais;
            this.provincia = provincia;
            this.municipio = municipio;
            this.calle = calle;
            this.codigo_postal = codigo_postal;
        }

        public String getPais() {
            return pais;
        }

        public void setPais(String pais) {
            this.pais = pais;
        }

        public String getProvincia() {
            return provincia;
        }

        public void setProvincia(String provincia) {
            this.provincia = provincia;
        }

        public String getMunicipio() {
            return municipio;
        }

        public void setMunicipio(String municipio) {
            this.municipio = municipio;
        }

        public String getCalle() {
            return calle;
        }

        public void setCalle(String calle) {
            this.calle = calle;
        }

        public int getCodigo_postal() {
            return codigo_postal;
        }

        public void setCodigo_postal(int codigo_postal) {
            this.codigo_postal = codigo_postal;
        }
    }


}
