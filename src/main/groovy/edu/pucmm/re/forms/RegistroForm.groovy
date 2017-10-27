package edu.pucmm.re.forms

import grails.validation.Validateable

class RegistroForm implements Validateable{

    long id
    String matricula
    String nombre;
    String email;
    String rfid;

    static constraints = {
        
    }
}
