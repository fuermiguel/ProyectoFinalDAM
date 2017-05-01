package com.example.fuerm.primeracouchbaseapp.objetos;

/**
 * Created by fuerm on 27/04/2017.
 */

public class Cliente {
    private String cif; //Obligatorio
    private String nombre; //Obligatorio
    private int telefono_fijo;
    private int telefono_movil;
    private Apellidos apellidos = new Apellidos(); //obligatorio
    private DireccionCliente direccionCliente = new DireccionCliente();

    class Apellidos{
        private String primer_apellido;
        private String segundo_apellido;

        public Apellidos() {
        }

        public Apellidos(String primer_apellido, String segundo_apellido) {
            this.primer_apellido = primer_apellido;
            this.segundo_apellido = segundo_apellido;
        }

        public String getPrimer_apellido() {
            return primer_apellido;
        }

        public void setPrimer_apellido(String primer_apellido) {
            this.primer_apellido = primer_apellido;
        }

        public String getSegundo_apellido() {
            return segundo_apellido;
        }

        public void setSegundo_apellido(String segundo_apellido) {
            this.segundo_apellido = segundo_apellido;
        }
    }
    class DireccionCliente{
        private String pais;
        private String provincia;
        private String municipio;
        private String calle;
        private int codigo_postal;

        public DireccionCliente() {
        }

        public DireccionCliente(String pais, String provincia, String municipio, String calle, int codigo_postal) {
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

    public Cliente() {
    }

    public Cliente(String cif, String nombre, Apellidos apellidos) {
        this.cif = cif;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono_fijo() {
        return telefono_fijo;
    }

    public void setTelefono_fijo(int telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public int getTelefono_movil() {
        return telefono_movil;
    }

    public void setTelefono_movil(int telefono_movil) {
        this.telefono_movil = telefono_movil;
    }

    public Apellidos getApellidos() {
        return apellidos;
    }

    public void setApellidos(Apellidos apellidos) {
        this.apellidos = apellidos;
    }

    public DireccionCliente getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(DireccionCliente direccionCliente) {
        this.direccionCliente = direccionCliente;
    }


}
