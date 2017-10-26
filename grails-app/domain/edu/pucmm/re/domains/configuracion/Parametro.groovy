package edu.pucmm.re.domains.configuracion

class Parametro {

    static final int ANTENA_ENTRADA = 1000
    static final int ANTENA_SALIDA = 1001
    static final int HABILITAR_NOTIFICACIONES = 1002

    int codigo
    String valor

    //Datos genericos del dominio.
    boolean habilitado = true;
    String creadoPor = "sistemas";
    String modificadoPor = "sistemas";
    Date dateCreated;
    Date lastUpdated;

    static constraints = {
    }

    static mapping={
        table("conf_parametros")
    }
}
