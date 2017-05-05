package com.example.fuerm.gestionoficinatecnica.objetos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuerm on 27/04/2017.
 */

public class Ficha {
    private String localizacion;
    private int numero_participantes;
    private boolean presencia_menores;
    private boolean accesible_discapacitados;
    private String tipo_evento;
    private String horario;
    private int numero_ambulancias;
    private Ambulancia ambulancia ;
    private List<Ambulancia> ambulancias;
    private boolean venta_alcohol;
    private int numero_aseos;
    private Aseo aseo;
    private List<Aseo> aseos;
    private boolean cortar_calles;
    private int numero_inchables;
    private Hinchable hinchable;
    private List<Hinchable> hinchables;
    private int numero_carpas;
    private Carpa carpa;
    private List<Carpa> carpas;

    public Ficha() {
        numero_ambulancias = 0;
        numero_aseos = 0;
        numero_carpas = 0;
        numero_inchables = 0;

        ambulancias = new ArrayList<Ambulancia>();
        aseos  = new ArrayList<Aseo>();
        hinchables = new ArrayList<Hinchable>();
        carpas = new ArrayList<Carpa>();

    }

    public class Medidas {
        private int alto;
        private int ancho;
        private int profundo;

        public int getProfundo() {
            return profundo;
        }

        public void setProfundo(int profundo) {
            this.profundo = profundo;
        }

        public int getAncho() {
            return ancho;
        }

        public void setAncho(int ancho) {
            this.ancho = ancho;
        }

        public int getAlto() {
            return alto;
        }

        public void setAlto(int alto) {
            this.alto = alto;
        }
    }

    public class DatosResponsable {
        private String cif;
        private DireccionResponsable direccionResponsable = new DireccionResponsable();
        private int telefono_fijo;
        private int telefono_movil;

        public class DireccionResponsable {
            private String pais;
            private String provincia;
            private String municipio;
            private String calle;
            private int codigo_postal;

            public DireccionResponsable() {
            }

            public DireccionResponsable(String pais, String provincia, String municipio, String calle, int codigo_postal) {
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

        public DireccionResponsable getDireccionResponsable() {
            return direccionResponsable;
        }

        public String getCif() {
            return cif;
        }

        public void setCif(String cif) {
            this.cif = cif;
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
    }

    public class Ambulancia {
        private String matricula;
        private String tipo;

        public Ambulancia() {
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getMatricula() {
            return matricula;
        }

        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }
    }

    public class Aseo {
        private String localizacion;
        private String tipo;

        public Aseo() {
        }

        public String getLocalizacion() {
            return localizacion;
        }

        public void setLocalizacion(String localizacion) {
            this.localizacion = localizacion;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
    }

    public class Hinchable {
        private String tipo;
        private Medidas medidas = new Medidas();
        private boolean anclajes;
        private DatosResponsable datosResponsable = new DatosResponsable();


        public Hinchable() {
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public Medidas getMedidas() {
            return medidas;
        }

        public boolean isAnclajes() {
            return anclajes;
        }

        public void setAnclajes(boolean anclajes) {
            this.anclajes = anclajes;
        }

        public DatosResponsable getDatosResponsable() {
            return datosResponsable;
        }
    }

    public class Carpa {

        private String modelo;
        private Medidas medidas = new Medidas();
        private boolean anclajes;
        private DatosResponsable datosResponsable = new DatosResponsable();

        public Carpa() {
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public Medidas getMedidas() {
            return medidas;
        }

        public void setMedidas(Medidas medidas) {
            this.medidas = medidas;
        }

        public boolean isAnclajes() {
            return anclajes;
        }

        public void setAnclajes(boolean anclajes) {
            this.anclajes = anclajes;
        }

        public DatosResponsable getDatosResponsable() {
            return datosResponsable;
        }

    }





    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public int getNumero_participantes() {
        return numero_participantes;
    }

    public void setNumero_participantes(int numero_participantes) {
        this.numero_participantes = numero_participantes;
    }

    public boolean isPresencia_menores() {
        return presencia_menores;
    }

    public void setPresencia_menores(boolean presencia_menores) {
        this.presencia_menores = presencia_menores;
    }

    public boolean isAccesible_discapacitados() {
        return accesible_discapacitados;
    }

    public void setAccesible_discapacitados(boolean accesible_discapacitados) {
        this.accesible_discapacitados = accesible_discapacitados;
    }

    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public boolean isVenta_alcohol() {
        return venta_alcohol;
    }

    public void setVenta_alcohol(boolean venta_alcohol) {
        this.venta_alcohol = venta_alcohol;
    }

    public boolean isCortar_calles() {
        return cortar_calles;
    }

    public void setCortar_calles(boolean cortar_calles) {
        this.cortar_calles = cortar_calles;
    }

    public int getNumero_ambulancias() {
        return ambulancias.size();
    }

    public int getNumero_aseos() {
        return aseos.size();
    }

    public int getNumero_inchables() {
        return hinchables.size();
    }

    public int getNumero_carpas() {
        return carpas.size();
    }

    public void setAmbulancia(Ambulancia ambulancia) {
        ambulancias.add(ambulancia);
    }

    public void setAseo(Aseo aseo) {
        aseos.add(aseo);
    }

    public void setCarpa(Carpa carpa) {
        carpas.add(carpa);
    }

    public void setHinchable(Hinchable hinchable) {
        hinchables.add(hinchable);
    }

    public List<Ambulancia> getAmbulancias() {
        return ambulancias;
    }

    public List<Aseo> getAseos() {
        return aseos;
    }

    public List<Hinchable> getHinchables() {
        return hinchables;
    }

    public List<Carpa> getCarpas() {
        return carpas;
    }

    public Ambulancia getAmbulancia() {
        return new Ambulancia();
    }

    public Aseo getAseo() {
        return new Aseo();
    }

    public Hinchable getHinchable() {
        return new Hinchable();
    }

    public Carpa getCarpa() {
        return new Carpa();
    }


}

