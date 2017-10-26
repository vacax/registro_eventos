package edu.pucmm.re.domains.eventos

class Registro {

    String nombre
    BigInteger rfid
    String email = "pendiente@pendiente.com"

    //Datos Ubicacion
    String ubicacion = ""

    //Datos genericos del dominio.
    boolean habilitado = true;
    String creadoPor = "sistemas";
    String modificadoPor = "sistemas";
    Date dateCreated;
    Date lastUpdated;

    static constraints = {
    }

    static mapping={
       table("ev_registro")
    }
}
