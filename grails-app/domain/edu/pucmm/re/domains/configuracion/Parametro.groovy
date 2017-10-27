package edu.pucmm.re.domains.configuracion

class Parametro {

    static final int ANTENA_ENTRADA = 1000
    static final int ANTENA_SALIDA = 1001
    static final int HABILITAR_NOTIFICACIONES = 1002
    static final int JMS_HABILITAR = 1003
    final static int JMS_URL = 1004
    final static int JMS_USUARIO = 1005
    final static int JMS_PASSWORD = 1006
    final static int JMS_COLA = 1007

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
