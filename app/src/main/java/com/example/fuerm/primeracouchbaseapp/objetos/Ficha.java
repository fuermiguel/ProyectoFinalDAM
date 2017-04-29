package com.example.fuerm.primeracouchbaseapp.objetos;

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
    private Ambulancias ambulancia;
    private boolean venta_alcohol;
    private int numero_aseos;
    private Aseos aseos;
    private boolean cortar_calles;
    private int numero_inchables;
    private Hinchables hinchables;
    private int numero_carpas;
    private Carpas carpas;

    public Ficha() {
    }

    public Ficha(String localizacion, int numero_participantes, boolean presencia_menores,
                 boolean accesible_discapacitados, String tipo_evento, String horario,
                 Ambulancias ambulancia, boolean venta_alcohol, int numero_aseos, Aseos aseos,
                 boolean cortar_calles, int numero_inchables, Hinchables hinchables,
                 int numero_carpas, Carpas carpas) {

        this.localizacion = localizacion;
        this.numero_participantes = numero_participantes;
        this.presencia_menores = presencia_menores;
        this.accesible_discapacitados = accesible_discapacitados;
        this.tipo_evento = tipo_evento;
        this.horario = horario;
        this.ambulancia = ambulancia;
        this.venta_alcohol = venta_alcohol;
        this.numero_aseos = numero_aseos;
        this.aseos = aseos;
        this.cortar_calles = cortar_calles;
        this.numero_inchables = numero_inchables;
        this.hinchables = hinchables;
        this.numero_carpas = numero_carpas;
        this.carpas = carpas;
    }

    class Ambulancias{
        private boolean presencia;
        private String tipo;

        public Ambulancias() {
        }

        public Ambulancias(boolean presencia, String tipo) {
            this.presencia = presencia;
            this.tipo = tipo;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public boolean isPresencia() {
            return presencia;
        }

        public void setPresencia(boolean presencia) {
            this.presencia = presencia;
        }
    }
    class Aseos{
        private String localizacion;
        private String tipo;

        public Aseos() {
        }

        public Aseos(String localizacion, String tipo) {
            this.localizacion = localizacion;
            this.tipo = tipo;
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
    class Hinchables{
        private String tipo;
        private Medidas medidas;
        private boolean anclajes;
        private DatosResponsable datosResponsable;

        public Hinchables() {
        }

        public Hinchables(DatosResponsable datosResponsable, String tipo, Medidas medidas, boolean anclajes) {
            this.datosResponsable = datosResponsable;
            this.tipo = tipo;
            this.medidas = medidas;
            this.anclajes = anclajes;
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

        public void setDatosResponsable(DatosResponsable datosResponsable) {
            this.datosResponsable = datosResponsable;
        }

        class Medidas{
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

        class DatosResponsable{

        }
    }
    class Carpas {

        private String modelo;
        private Medidas medidas;
        private boolean anclajes;
        private DatosResponsable datosResponsable;
        private int telefono_movil;
        private int telefono_fijo;

        public Carpas() {
        }

        public Carpas(String modelo, Medidas medidas, boolean anclajes,
                      DatosResponsable datosResponsable, int telefono_movil, int telefono_fijo) {
            this.modelo = modelo;
            this.medidas = medidas;
            this.anclajes = anclajes;
            this.datosResponsable = datosResponsable;
            this.telefono_movil = telefono_movil;
            this.telefono_fijo = telefono_fijo;
        }

        class Medidas {
            private int alto;
            private int ancho;
            private int profundo;

            public Medidas() {
            }

            public Medidas(int alto, int ancho, int profundo) {
                this.alto = alto;
                this.ancho = ancho;
                this.profundo = profundo;
            }

            public int getAlto() {
                return alto;
            }

            public void setAlto(int alto) {
                this.alto = alto;
            }

            public int getAncho() {
                return ancho;
            }

            public void setAncho(int ancho) {
                this.ancho = ancho;
            }

            public int getProfundo() {
                return profundo;
            }

            public void setProfundo(int profundo) {
                this.profundo = profundo;
            }
        }

        class DatosResponsable {
            private String cif;
            private DireccionResponsable direccionResponsable;
            private int telefono_fijo;
            private int telefono_movil;

            class DireccionResponsable {
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

    public Ambulancias getAmbulancia() {
        return ambulancia;
    }

    public void setAmbulancia(Ambulancias ambulancia) {
        this.ambulancia = ambulancia;
    }

    public boolean isVenta_alcohol() {
        return venta_alcohol;
    }

    public void setVenta_alcohol(boolean venta_alcohol) {
        this.venta_alcohol = venta_alcohol;
    }

    public int getNumero_aseos() {
        return numero_aseos;
    }

    public void setNumero_aseos(int numero_aseos) {
        this.numero_aseos = numero_aseos;
    }

    public Aseos getAseos() {
        return aseos;
    }

    public void setAseos(Aseos aseos) {
        this.aseos = aseos;
    }

    public boolean isCortar_calles() {
        return cortar_calles;
    }

    public void setCortar_calles(boolean cortar_calles) {
        this.cortar_calles = cortar_calles;
    }

    public int getNumero_inchables() {
        return numero_inchables;
    }

    public void setNumero_inchables(int numero_inchables) {
        this.numero_inchables = numero_inchables;
    }

    public Hinchables getHinchables() {
        return hinchables;
    }

    public void setHinchables(Hinchables hinchables) {
        this.hinchables = hinchables;
    }

    public int getNumero_carpas() {
        return numero_carpas;
    }

    public void setNumero_carpas(int numero_carpas) {
        this.numero_carpas = numero_carpas;
    }

    public Carpas getCarpas() {
        return carpas;
    }

    public void setCarpas(Carpas carpas) {
        this.carpas = carpas;
    }
}
