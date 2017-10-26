package edu.pucmm.re.domains.eventos

class Evento {

    
    String nombre
    Date fechaInicio
    Date fechaFin

    //Datos genericos del dominio.
    boolean habilitado = true;
    String creadoPor = "sistemas";
    String modificadoPor = "sistemas";
    Date dateCreated;
    Date lastUpdated;

    static constraints = {
    }

    static mapping={
        table("ev_evento")
    }
}
