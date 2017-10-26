package edu.pucmm.re.domains.eventos

class MovEntradaSalida {

    //Informacion
    Registro registro
    Evento evento
    String accion
    int antena
    String rfid

    //Datos genericos del dominio.
    boolean habilitado = true;
    String creadoPor = "sistemas";
    String modificadoPor = "sistemas";
    Date dateCreated;
    Date lastUpdated;

    static constraints = {
    }

    static mapping={
       table("ev_mov_entrada_salida")
    }
}
